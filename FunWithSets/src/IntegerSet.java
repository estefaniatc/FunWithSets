

public class IntegerSet {

	private int[] elements;
	private int numElements;

	public IntegerSet(int maxElements) {
		elements = new int[maxElements];
		numElements = 0;
	}
	public IntegerSet(int[] numbers) {
		elements = new int[numbers.length * 2];
		for (int i=0; i<numbers.length; i++) {
			elements[i] = numbers[i];
		}
		numElements = numbers.length;

	}

	public boolean isMember(int key) {
		for(int i=0; i<numElements; i++) {
			if (key == elements[i])
				return true;
		}
		return false;
	}

	public int[] getElements() {
		return elements;
	}
	public int getNumElements() {
		return numElements;
	}
	public void setElements(int[] elements) {
		this.elements = elements;
	}
	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	public int getCardinality() {
		return numElements;
	}

	public int getSum() {
		int sum = 0;
		for(int i=0; i<numElements; i++) {
			sum = sum + elements[i];	
		}
		return sum;
	}

	public boolean allEven() {
		for(int i=0; i<numElements; i++) {
			if (elements[i] % 2 == 1) {
				return false;
			}
		}
		return true;
	}

	public IntegerSet mapSquares() {
		int[] squares = new int[numElements];
		for(int i=0; i<numElements; i++) {
			squares[i] = elements[i] * elements[i];
		}
		return new IntegerSet(squares);
	}

	public void add(int newElement) {
		if (numElements >= elements.length) {
			// Make new array to increase space
			int[] newElements = new int[elements.length * 2];
			for (int i=0; i<numElements; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
		elements[numElements] = newElement;
		numElements++;
	}

	public IntegerSet intersection(IntegerSet s2) {
		IntegerSet result = new IntegerSet(Math.min(this.getCardinality(), s2.getCardinality()));

		for(int i=0; i<this.getCardinality(); i++) {
			if (s2.isMember(elements[i])) {
				result.add(elements[i]);
			}
		}
		return result;
	}
	
	public IntegerSet union(IntegerSet s2) {
		IntegerSet result = new IntegerSet(this.getCardinality() + s2.getCardinality());
		
		for(int i=0; i<getCardinality(); i++) {
			result.add(elements[i]);
		}
		
		for(int i=0; i<s2.getCardinality(); i++) {
			if (!result.isMember(s2.elements[i])) {
				result.add(s2.elements[i]);
			}
		}
		return result;
	}
}
