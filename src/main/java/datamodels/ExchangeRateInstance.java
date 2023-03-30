package datamodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateInstance {

    private double exchangeRate;
    private Date from;
    private Date to;
}
