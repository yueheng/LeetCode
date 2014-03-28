class Entry {
    String key;
    int value;
    Entry next;
	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
		next = null;
	}
}

public class HashMap {
    private int size;
    private int capacity;
    private Entry[] entry;
    public HashMap() {
        size = 0;
        capacity = 100;
        entry = new Entry[capacity];
    }
    public HashMap(int cap) {
        
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        reutrn size == 0;
    }
    public int put(String key, int value) {
		if(key == null) return null;
        int hash = key.hashCode() % capacity;
		Entry e = entry[hash];
		Entry prev = e;
		for(; e != null; e = e.next) {
			prev = e;
			String k = e.key;
			if(k == key || key.equals(k)) {
				int oldVelue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		Entry next = new Entry(key, value);
		prev.next = next;
		return null;
    }
	public int get(String key) {
		if(key == null) return null;
		int hash = key.hashCode() % capacity;
		Entry e = entry[hash];
		for(; e != null; e = e.next) {
			String k = e.key;
			if(k == key || key.equals(k)) {
				int value = e.value;
				return value;
			}
		}
		return null;
	}
}