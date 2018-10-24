import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int size = size();

        for (int j = size; j > 0; j--) {
            storage[j-1] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
        size();
    }

    Resume get(String uuid) {
        Resume res = null;

        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                res = storage[i];
                break;
            }
        }
        return res;
    }

    void delete(String uuid) {
        Resume[] tmp = new Resume[10000];

        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                do {
                    tmp[i] = storage[i+1];
                    i++;
                } while (storage[i] != null);
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
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int size = 0;

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
