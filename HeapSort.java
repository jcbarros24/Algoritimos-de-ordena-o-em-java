public class HeapSort{

	public void sort(int arr[]){
		int n = arr.length;

		System.out.println("Entrada:");
		printArray(arr);
		System.out.println();
		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i > 0; i--){
			heapify(arr, n, i);
			
		}
		printArray(arr);
		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);

			printArray(arr);// TESTE TESTE TESTE			
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	void heapify(int arr[], int n, int i)
	{
		int largest = i; // inicia o maior como a Raiz
		int l = 2 * i + 1; // esquerda = 2*i + 1
		int r = 2 * i + 2; // direita = 2*i + 2

		// Se o filho da esquerda for maior que a raiz
		if (l < n && arr[l] > arr[largest])
			largest = l;

		// Se o filho da direita for maior que o maior até então
		if (r < n && arr[r] > arr[largest])
			largest = r;

		// Se o maior não for a raiz
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	//Serve apenas para printar a árvore.
	void printArray(int arr[]){
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
    }
    
}