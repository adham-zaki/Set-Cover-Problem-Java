import java.util.*;

// Holds all Set Cover Problem (SCP) model data
//
// An SCP contains a set of ElementSets (see that class for its definition).
// An SCP also directly stores all the unique Element IDs in the problem for convenient access.
public class SCPModel {
	
	private SortedSet<ElementSet> _elementSets; // A set of ElementSets, sorted by ID
	private SortedSet<Integer>    _elements;    // A set of all Element IDs in this SCP model, sorted by ID
	
	public SCPModel() {
		_elementSets = new TreeSet<ElementSet>();
		_elements    = new TreeSet<Integer>();
	}
	
	// Add an ElementSet to this SCPModel
	public void addElementSet(int id, double cost, Collection<Integer> elements) {
		// TODO: make a new ElementSet and update the two data members of this class
		ElementSet ES = new ElementSet(id, cost, elements);
		_elementSets.add(ES);
		_elements.addAll(elements);
	}
	
	// Get the total number of Element IDs in this SCPModel
	public int getNumElements() {
		return _elements.size();
	}
	
	// Get the total number of Set IDs in this SCPModel
	public int getNumElementSets() {
		return _elementSets.size();
	}
	
	public SortedSet<Integer> getAllEs(){
		TreeSet<Integer> temp = new TreeSet<Integer>();
		temp.addAll(_elements);
		return temp;
	}
	
	// TODO: AS YOU CODE THE GREEDY ALGORITHMS, ADD NEW METHODS HERE AS NEEDED
	
	// With the following method, we can write 
	//   for (ElementSet e : getElementSetIterable()) { 
	//      do something with e;
	//   }
	// so that we can iterate through the ElementSets in this
	// class *without having any further ability to modify* the
	// underlying _elementSets instance.  See usage in toString() 
	// below.
	public Iterable<ElementSet> getElementSetIterable() {
		return (Iterable<ElementSet>)_elementSets;
	}

	// Print out model details
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nWeighted SCP model:\n");
		sb.append("---------------------\n");
		sb.append("Number of elements (n): " + getNumElements() + "\n");
		sb.append("Number of sets (m): " + getNumElementSets() + "\n");
		sb.append("\nSet details:\n");
		String.format("%3s%10s%23s%19s\n","No.", "Cost", "No. elements covered","Elements covered");
		sb.append("----------------------------------------------------------\n");
		for (ElementSet e : getElementSetIterable())
			sb.append(e + "\n");
		return sb.toString();
	}
}
