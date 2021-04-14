import java.math.BigDecimal;

public class TestStringFormat {

    public static void main(String args[]) {

        BigDecimal commissionRate = new BigDecimal("0.05");
        String yesFlag ="yes";
        String noFlag ="no";
        String channelKey= "GLOBAL";
        long invoiceId = 222222;
        int quantity = 11;
        int productOptionId=11112;
        String status="RESTRICTED";
        int count=4;
        String channelName="BRIDGE2SOLUTION";

        // String str = "GeeksforGeeks.";

        // Concatenation of two strings
        String gfg1 = String.format("My Company name is :");

        // Output is given upto 8 decimal places
        String str2 = String.format("My answer is %.8f", 47.65734);

        // between "My answer is" and "47.65734000" there are 15 spaces
        String str3 = String.format("My answer is %15.8f", 47.65734);

        System.out.println(commissionRate);
        System.out.println(gfg1);
        System.out.println(str2);
        System.out.println(str3);

            String sql = "update marketpartner.EOS_COMMISSION_CONFIG set commission_rate =" + commissionRate + "" +
                    ", shipping_commission_rate=" + commissionRate + ", SHIPPING_COMMISSION_FLAG='" + yesFlag + "'" +
                    ", SITESALE_COMMISSION_FLAG='" + noFlag + "', USE_CALCULATED_SHIP_COMM_FLAG='" + yesFlag + "'" +
                    ", USE_COMMISSION_STRATEGY_FLAG='" + yesFlag + "', CALCULATE_TRANSACT_FEES_FLAG='" + noFlag + "'" +
                    ", secondary_commission_rate=" + commissionRate + " where channel_key='" + channelKey + "'";
            System.out.println(sql);
            String sql1=String.format("update marketpartner.EOS_COMMISSION_CONFIG set commission_rate = %f, " +
                    "shipping_commission_rate= %f, SHIPPING_COMMISSION_FLAG= '%s', SITESALE_COMMISSION_FLAG= '%s', " +
                    "USE_CALCULATED_SHIP_COMM_FLAG= '%s', USE_COMMISSION_STRATEGY_FLAG= '%s', " +
                    "CALCULATE_TRANSACT_FEES_FLAG= '%s', secondary_commission_rate=%f,where channel_key= '%s'"
                    ,commissionRate,commissionRate,yesFlag,noFlag,yesFlag,yesFlag,noFlag,commissionRate,channelKey);
            System.out.println(sql1);


        String sql2=String.format("update marketpartner.EOS_COMMISSION_CONFIG set commission_rate = %f , shipping_commission_rate=%f, SHIPPING_COMMISSION_FLAG=%s,SITESALE_COMMISSION_FLAG=%s, USE_CALCULATED_SHIP_COMM_FLAG=%s, USE_COMMISSION_STRATEGY_FLAG=%s, CALCULATE_TRANSACT_FEES_FLAG=%s, secondary_commission_rate=%f, where channel_key=%s",commissionRate,commissionRate,yesFlag,noFlag,yesFlag,yesFlag,noFlag,commissionRate,channelKey);
        System.out.println(sql2);


        String sf3=String.format("select * from marketpartner.channel_order_line where invoice_item_id = %d", invoiceId );
        System.out.println(sf3);

        String sql4 = "Select * from MARKETPARTNER.channel_order where invoice_id = " + invoiceId + "";
        System.out.println(sql4);
        String a = "Hello" + invoiceId + "";

        String sql5=String.format("Select * from MARKETPARTNER.channel_order where invoice_id = %d", invoiceId );
        System.out.println(sql5);

        String sql6 = "update INVENTORY.LOCATION_INVENTORY set qty_on_hand = " + quantity + " where product_option_id in (" + productOptionId + ")";
        System.out.println(sql6);
        System.out.println("...................");
        String sql7 = String.format("update INVENTORY.LOCATION_INVENTORY set qty_on_hand = %d where product_option_id in (%d)", quantity,productOptionId);
        System.out.println(sql7);
        System.out.println("+++++++++++++++");


        String sql8 = "select PRI_ID, PRI_PRICE, pri_pro_od From dd_pro_info where pri_pro_od in " +
                "(select pro_id as pri_pro_od from marketpartner.channel_product where channel_key='" + channelName +
                "' and status='" + status + "') FETCH FIRST " + count + " ROWS ONLY";
        System.out.println(sql8);
        System.out.println("=================");

        String sql9 = String.format("select PRI_ID, PRI_PRICE, pri_pro_od From dd_pro_info where" +
                " pri_pro_od in (select pro_id as pri_pro_od from marketpartner.channel_product where" +
                " channel_key='%s' and status='%s') FETCH FIRST %d ROWS ONLY",channelName,status,count);

        System.out.println(sql9);




    }


    }




