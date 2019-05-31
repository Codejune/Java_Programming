abstract class PairMap {
    protected String[] keyArray; // key들을 저장하는 배열
    protected String[] valueArray; // value들을 저장하는 배열
    abstract String get(String key); // key값을 가진 value 리턴 , 없으면 null
    abstract void put(String key, String value); // key, value를 쌍으로 저장, 기존의 key가 존재시 value값 수정
    abstract String delete(String key); // 해당 key값을 가진 value와 함께 삭제, 해당 value 리턴
    abstract int length(); // 현재 저장된 아이템의 개수 리턴
}

class Dictionary extends PairMap {
    private int length = 0;
    Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
    }

    @Override
    String get(String key) {
        for(int i = 0; i < length; i++) {
            if(keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    void put(String key, String value) {
        boolean check = false;
        for(int i = 0; i < length; i++) {
            if (keyArray[i].equals(key)) {
                valueArray[i] = value;
                check = true;
                break;
            }
        }
        if(!check) {
            keyArray[length] = key;
            valueArray[length] = value;
            length++;
        }
    }

    @Override
    String delete(String key) {
        for(int i = 0; i < length; i++) {
            if (keyArray[i].equals(key)) {
                String deletevalue = keyArray[i];
                suit(i);
                length--;
                return deletevalue;
            }
        }
        return null;
    }

    @Override
    int length() {
        return length;
    }

    private void suit(int index) {
        for(int i = index; i < this.length; i++) {
            keyArray[i] = keyArray[i + 1];
            valueArray[i] = valueArray[i + 1];
        }
        valueArray[length] = "";
    }
}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
