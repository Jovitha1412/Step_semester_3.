
package Assignment_Problems.s8;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Map;

public class streamplan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Subscription> plans = Map.of(
                "BASIC", new BasicPlan(),
                "STANDARD", new StandardPlan(),
                "PREMIUM", new PremiumPlan()
        );

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Subscription plan = plans.get(type);
            LocalDate renewalDate = plan.calculateRenewal(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }

    static abstract class Subscription {
        abstract int getValidityDays();

        LocalDate calculateRenewal(LocalDate startDate) {
            return startDate.plusDays(getValidityDays());
        }
    }

    static class BasicPlan extends Subscription {
        int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Subscription {
        int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Subscription {
        int getValidityDays() {
            return 365;
        }
    }
}
