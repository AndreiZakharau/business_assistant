package servise.date;

import java.time.LocalDate;

public class DateDelivery {
    private LocalDate ld;

    public LocalDate inLd(){
        ld = LocalDate.now();
        return ld;
    }

    public DateDelivery() {
    }

    public LocalDate getLd() {
        return ld;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }
}
