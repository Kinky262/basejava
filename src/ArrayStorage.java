import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = size();

    void clear() {
        for (int j = 0; j < size; j++) {
            storage[j] = null;
            size --;
        }
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] tmp = new Resume[10000];

        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                do {
                    tmp[i] = storage[i+1];
                    i++;
                } while (storage[i] != null);
                size--;
            } else {
                tmp[i] = storage[i];
            }
        }
        storage = Arrays.copyOf(tmp, tmp.length);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        size = 0;

        for (Resume i:storage) {
            if (i != null) {
                size++;
            } else {
                break;
            }
        }
        return size;
    }
}
