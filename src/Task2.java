import java.util.*;

class RocketEvent {
    int minute;
    int id;
    char status;

    public RocketEvent(int minute, int id, char status) {
        this.minute = minute;
        this.id = id;
        this.status = status;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Количество записей в логе
        scanner.nextLine(); // Считываем перевод строки

        // Создаем список событий
        List<RocketEvent> events = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int day = Integer.parseInt(parts[0]);
            int hour = Integer.parseInt(parts[1]);
            int minute = Integer.parseInt(parts[2]);
            int id = Integer.parseInt(parts[3]);
            char status = parts[4].charAt(0);

            if (status != 'B'){
            events.add(new RocketEvent((((day * 24) + hour) * 60)+minute, id, status));}
        }

        // Сортируем события по дате и времени
        Collections.sort(events, Comparator.comparingInt(e -> e.minute));

        // Мапа для хранения времени движения для каждой ракеты
        Map<Integer, Integer> rocketMovementTime = new HashMap<>();
        System.out.println(events);
        for (int i=0; i<events.size(); i++) {
            if (events.get(i).status == 'A'){
                for (int j = i+1; j < events.size(); j++) {
                    if (events.get(j).id == events.get(i).id && (events.get(j).status == 'C' || events.get(j).status == 'S')){
                        rocketMovementTime.put(events.get(i).id, (events.get(j).minute - events.get(i).minute) + rocketMovementTime.getOrDefault(events.get(j).id, 0));
                        break;
                    }
                }
            }
        }
        for (var a: rocketMovementTime.values()) {
            System.out.print(a + " ");
        }

        scanner.close();
    }
}

