package Code;

import java.util.*;

public class Episode {
    private int length;
    private Date productionDate = new Date();

    public Episode(Date previousEpisodeDate, int length) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(previousEpisodeDate);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        this.productionDate = calendar.getTime();
        this.length = length;
    }

    public Date getProductionDate() {
        return productionDate;
    }
}
