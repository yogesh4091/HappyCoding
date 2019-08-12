import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Cursor {

  public static void main(String[] args) throws AWTException, InterruptedException {

    //    Robot robot = new Robot();
    //    int i = 0;
    //    while (true) {
    //      Thread.sleep(6000);
    //      robot.mouseMove(i, i);
    //      i++;
    //      if (i > 2000) i = 0;
    //    }

//    getDateFromCron(LocalDateTime.now(),"0 */2 * * * *",2);

    String s = "select o.order_number as purchaseOrder,DATE_FORMAT(o.shipment_date, '%d-%b-%Y') as orderShipmentDate,"
        + "o.seller_id as sellerId,o.seller_name as sellerName,o.fx_rate as guaranteedFxRate,"
        + "o.rate_set_id as rateSetId,ROUND(o.international_shipping_cost_fedex*o.fx_rate,4) as shipInCad,"
        + "ROUND(o.duty*o.fx_rate,4) as dutyInCad,ROUND(o.taxes*o.fx_rate,4) as taxesInCad,"
        + "ROUND(o.loss_and_damage_cost*o.fx_rate,4) as lossAndDamagedInCad,"
        + "ROUND(o.fx_rate*(o.export_facilitation_fee+o.hub_handling_fee),4) as exportFacilitationFeeInCad,"
        + "ROUND(o.fx_rate*(((o.international_shipping_cost_walmart-o.international_shipping_cost_fedex)"
        + "+(s.export_facilitation-(o.hub_handling_fee+o.export_facilitation_fee)))+"
        + "s.insurance*((o.international_shipping_cost_walmart-o.international_shipping_cost_fedex)"
        + "+(s.export_facilitation-(o.hub_handling_fee+o.export_facilitation_fee)))),4) as cbtMarkupInCad,"
        + "ROUND((select shipInCad)+(select dutyInCad)+(select taxesInCad)+(select lossAndDamagedInCad)+"
        + "(select exportFacilitationFeeInCad)+(select cbtMarkupInCad),4) as totalToHoldInCad from "
        + "orderline_shipment_details o,seller_metadata s where o.seller_id=s.seller_id and "
        + "s.seller_type=:sellerType and o.impl_version=:implVersion "
        + "and batch_date between :startDate and :endDate order by o.shipment_date";
    System.out.println(s);

  }

  /**
   * @param localDateTime  Time based on which next/previous time will be calculated.
   * @param cronExpression Cron expression in Spring form with 6 values.
   * @param seek           +ve value for next iteration and -ve value for previous iteration.
   * @return
   */
  public static LocalDateTime getDateFromCron(
      LocalDateTime localDateTime, String cronExpression, int seek) {

    CronDefinition cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.SPRING);
    CronParser parser = new CronParser(cronDefinition);
    Cron quartzCron = parser.parse(cronExpression);
    ZonedDateTime now = localDateTime.atZone(ZoneId.of("UTC"));

    ExecutionTime executionTime = ExecutionTime.forCron(quartzCron);

    if (seek < 0) {
      while (seek < 0) {
        now = executionTime.lastExecution(now).get();
        seek++;
      }
      return now.toLocalDateTime();
    } else if (seek > 0) {
      while (seek > 0) {
        now = executionTime.nextExecution(now).get();
        seek--;
      }
      return now.toLocalDateTime();
    } else {
      return localDateTime;
    }
  }
}
