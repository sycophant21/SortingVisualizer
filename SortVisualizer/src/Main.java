import com.helper.SortFactory;
import com.helper.Workflow;
import com.window.Frame;
import com.window.Panel;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        List<Double> tempList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            tempList.add((double) new Random().nextInt(length * length) + length);
        }
        Panel panel = new Panel();
        Frame frame = new Frame(panel);

        SortFactory sortFactory = new SortFactory(new HashMap<>(), panel);
        new Workflow(sortFactory.getSortHelpers("Insert"),
                panel)
                .doSort(tempList);

    }
}
