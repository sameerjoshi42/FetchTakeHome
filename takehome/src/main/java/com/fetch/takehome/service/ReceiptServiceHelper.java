package com.fetch.takehome.service;

import com.fetch.takehome.constants.ReceiptProcessorConstants;
import com.fetch.takehome.exception.ReceiptProcessorException;
import com.fetch.takehome.model.Item;
import com.fetch.takehome.utils.ReceiptUtils;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReceiptServiceHelper {

    public int calculatePointsForAlphanumericChar(String retailer){
        int points = ReceiptProcessorConstants.ZERO;
        if(!retailer.isEmpty()){
            for(Character ch:retailer.toCharArray()){
                if(Character.isLetterOrDigit(ch)){
                    points++;
                }
            }
        }
        else{
            throw new ReceiptProcessorException(ReceiptProcessorConstants.RETAIL_NOT_EMPTY_MESSAGE);
        }
        return points;
    }

    public int calculatePointsForRoundFigureAmt(Double total){
        Double amount = Math.ceil(total);
        if(Double.compare(amount,total)==ReceiptProcessorConstants.ZERO){
            return ReceiptProcessorConstants.FIFTY;
        }
        return ReceiptProcessorConstants.ZERO;
    }

    public int calculatePointsForPointTwentyFiveMultiple(Double total){
        if(total!=null){
            if (total % ReceiptProcessorConstants.POINT_TWENTY_FIVE ==
                    ReceiptProcessorConstants.ZERO) {
                return ReceiptProcessorConstants.TWENTY_FIVE;
            }
        }
        return ReceiptProcessorConstants.ZERO;
    }
    public int calculatePointsPerItemsSize(int numberOfItems){
        return (numberOfItems/2)*5;
    }

    public int calculatePointsPerItemDesc(List<Item> items){
        if(items.isEmpty()){
            throw new ReceiptProcessorException(ReceiptProcessorConstants.ITEM_LIST_NOT_EMPTY_MESSAGE);
        }

        List<Item> itemList =  items.stream()
            .filter(item -> item.getShortDescription().trim().length()%3==0).collect(Collectors.toList());

      if(itemList.isEmpty()){
          return ReceiptProcessorConstants.ZERO;
      }
      Integer points = itemList.stream()
              .map(item ->Math.ceil(item.getPrice()*0.2))
              .reduce(Double::sum).get().intValue();
      return points;
    }

    public int calculatePointsForOddDate(Date date){
        if(date!=null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int purchaseDate = calendar.get(Calendar.DAY_OF_MONTH);
            if(purchaseDate%2!=ReceiptProcessorConstants.ZERO){
                return ReceiptProcessorConstants.SIX;
            }
        }
       return ReceiptProcessorConstants.ZERO;
    }

    public int calculatePointsPerPurchaseTime(Date date,String purchaseDate){
        if(date!=null && !purchaseDate.isEmpty()){
            Date after = ReceiptUtils.convertStringToDate(purchaseDate, ReceiptProcessorConstants.TWO_PM);
            Date before = ReceiptUtils.convertStringToDate(purchaseDate,ReceiptProcessorConstants.FOUR_PM);
            if(date.after(after) && date.before(before)){
                return ReceiptProcessorConstants.TEN;
            }
        }
        return ReceiptProcessorConstants.ZERO;
    }
}
