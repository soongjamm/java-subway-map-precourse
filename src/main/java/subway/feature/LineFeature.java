package subway.feature;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.menu.StationMenu;
import subway.view.LineInputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineFeature {

    public static void registerLine(Scanner scanner) {
        try {
            String line = LineInputView.register(scanner);
            String upBoundTerminus = LineInputView.upBoundTerminus(scanner);
            String downBoundTerminus = LineInputView.downBoundTerminus(scanner);

            Line newLine = new Line(line);
            newLine.addTerminus(upBoundTerminus, downBoundTerminus);
            LineRepository.addLine(newLine);

            System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }

    public static void removeLine(Scanner scanner) {
        try {
            String line = LineInputView.remove(scanner);
            LineRepository.deleteLineByName(line);

            System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            StationMenu.openScreen(scanner);
        }
    }

    public static void inquiryLine() {
        System.out.println("[INFO] 노선 목록");
        OutputView.printLines();
    }
}
