package entities;
import exception.ExceptionMain;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer numQuarto;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numQuarto, Date checkin, Date checkout) throws ExceptionMain {
        if(!checkout.after(checkin)) {
            throw new ExceptionMain("as datas de check-in e check-out são anteriores a agora");
        }
        this.numQuarto = numQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(Integer numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff =  checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void update(Date checkin, Date checkout) throws ExceptionMain {
        Date now = new Date();
        if(checkin.before(now) || checkout.before(now)) {
            throw new ExceptionMain("as datas de check-in e check-out são anteriores a agora");
        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return  "Room "
                + numQuarto
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }
}
