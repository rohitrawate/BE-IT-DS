package MPIsum;

import mpi.*;

public class DistributedSum {
    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int N = 100; // Number of elements
        int[] array = new int[N]; // Input array
        int localSum = 0; // Local sum at each processor
        int[] globalSum = new int[1]; // Global sum

        // Generate the array (example: 0 to N-1)
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }

        // Calculate the local sum for each processor
        int elementsPerProcessor = N / size;
        int startIndex = rank * elementsPerProcessor;
        int endIndex = (rank + 1) * elementsPerProcessor;

        for (int i = startIndex; i < endIndex; i++) {
            localSum += array[i];
        }

        // Display the intermediate sums calculated at different processors
        System.out.println("Processor " + rank + ": Intermediate Sum = " + localSum);

        // Reduce the local sums to get the global sum
        MPI.COMM_WORLD.Reduce(new int[]{localSum}, 0, globalSum, 0, 1, MPI.INT, MPI.SUM, 0);

        // Display the global sum at the root processor
        if (rank == 0) {
            System.out.println("Global Sum = " + globalSum[0]);
        }

        MPI.Finalize();
    }
}
