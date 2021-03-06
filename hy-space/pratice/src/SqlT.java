public class SqlT {

    public static void main(String[] args) {
        String sql = "SELECT\n" +
                "\ta.cp_id,\n" +
                "\ta.FILEITEM,\n" +
                "\ta.FILENAME,\n" +
                "b.qy_id,\t"+
                "\t'/3310a/lxsoft/cpsb/workbase/cpsbserver/upload/qy_data/Y2006M8/' || b.qy_id || '/' || a.filename AS path \n" +
                "FROM\n" +
                "\tggbak.FBCX_FILES_UP_move a,\n" +
                "\tggbak.yzk_move b \n" +
                "WHERE\n" +
                "\ta.cp_id = b.sb_id \n" +
                "\t";
        System.out.println(sql);

        String str = "GX101228_1575708954666\n" +
                "GX101228_1575704823683\n" +
                "GX190258_1567598072374\n" +
                "GX190258_1566984750879\n" +
                "GX100008_1566267592351\n" +
                "GX190258_1567598072374\n" +
                "GX101228_1575708954666\n" +
                "GX101228_1575708954666\n" +
                "GX101228_1575704823683\n" +
                "GX101228_1575708954666\n" +
                "GX100684_1573262257251\n" +
                "GX190258_1566984750879\n" +
                "GX101228_1575708954666\n" +
                "GX101228_1575704823683\n" +
                "GX190210_1573193674647\n" +
                "GX190210_1573193674647\n" +
                "GX100008_1566267592351\n" +
                "GX190258_1566984750879\n" +
                "GX100008_1566267592351\n" +
                "GX100684_1573262257251\n" +
                "GX190258_1567598072374\n" +
                "GX101228_1575704823683\n" +
                "GX190258_1567598072374\n" +
                "GX100008_1566267592351\n" +
                "GX100008_1566267592351\n" +
                "GX190258_1567598072374\n" +
                "GX100684_1573262257251\n" +
                "GX030252_1574678980619\n" +
                "GX190258_1566984750879\n" +
                "GX190232_1564321737442\n" +
                "GX101204_1575287212256\n" +
                "GX130216_1574825021352\n" +
                "GX190232_1564321737442\n" +
                "GX190232_1564321737442\n" +
                "GX101204_1575287212256\n" +
                "GX130216_1574825021352\n" +
                "GX190232_1566285078272\n" +
                "GX160004_1574411962284\n" +
                "GX030252_1574762159784\n" +
                "GX100684_1573262257251\n" +
                "GX101204_1575267645907\n" +
                "GX101204_1575267645907\n" +
                "GB170008_1574143803259\n" +
                "GX101204_1575287212256\n" +
                "GX030252_1574678981829\n" +
                "GX190258_1566984750879\n" +
                "GX101204_1575287212256\n" +
                "GX130216_1574825021352\n" +
                "GX101204_1575267645907\n" +
                "GX101224_1575007080370\n" +
                "GX190232_1566285078272\n" +
                "GX190232_1564321737442\n" +
                "GX101204_1575267645907\n" +
                "GX101224_1575007080370\n" +
                "GX120004_1575450413027\n" +
                "GX190232_1566285078272\n" +
                "GX190232_1564321737442\n" +
                "GX160004_1574411962284\n" +
                "GX101204_1575267645907\n" +
                "GX101224_1575007080370\n" +
                "GX190232_1566285078272\n" +
                "GB170008_1574143803259\n" +
                "GX190258_1566984750879\n" +
                "GX101204_1575287212256\n" +
                "GX101204_1575287212256\n" +
                "GX120004_1575450413027\n" +
                "GE180012_1573866543312\n" +
                "GE180012_1573866543312\n" +
                "GX130216_1574825021352\n" +
                "GX130216_1574825021352\n" +
                "GX190232_1566285078272\n" +
                "GE180012_1574818051307\n" +
                "GE180012_1574818051307\n" +
                "GX101224_1575007080370\n" +
                "GX130216_1574825021352\n" +
                "GX030252_1574762159784\n" +
                "GX160004_1574411962284\n" +
                "GX101204_1575267645907\n" +
                "GX160004_1574411962284\n" +
                "GX190232_1564321737442\n" +
                "GX101224_1575007080370\n" +
                "GX030252_1574678981829\n" +
                "GX030252_1574678980619\n" +
                "GX190232_1566285078272\n" +
                "GX190232_1567248586478\n" +
                "GX100286_1561616817679\n" +
                "GX190232_1567248586478\n" +
                "GX101204_1574307255163\n" +
                "GX221012_1567048337028\n" +
                "GX100286_1561616817679\n" +
                "GX190232_1567063599382\n" +
                "GX090240_1568002742734\n" +
                "GX221012_1567048337028\n" +
                "GX230208_1569552989263\n" +
                "GX190232_1567063599382\n" +
                "GX221012_1567048337028\n" +
                "GB160006_1566902695678\n" +
                "GX101204_1575287212256\n" +
                "GX111002_1574923653040\n" +
                "GX100286_1561616817679\n" +
                "GX090240_1568002742734\n" +
                "GX230208_1569552989263\n" +
                "GX090240_1568002742734\n" +
                "GX100286_1561616817679\n" +
                "GX190232_1567063599382\n" +
                "GX090240_1568002742734\n" +
                "GX090240_1568002742734\n" +
                "GX190232_1567248586478\n" +
                "GX190232_1567063599382\n" +
                "GX111002_1574923653040\n" +
                "GX190232_1567248586478\n" +
                "GE191032_1573201536192\n" +
                "GX111002_1574923653040\n" +
                "GX101204_1574307255163\n" +
                "GX111002_1574923653040\n" +
                "GB160006_1566902695678\n" +
                "GX120044_1574489272415\n" +
                "GX120044_1574489272415\n" +
                "GX100286_1561616817679\n" +
                "GX230208_1569552989263\n" +
                "GX120044_1574489272415\n" +
                "GX120044_1574489272415\n" +
                "GX090240_1568002742734\n" +
                "GX221012_1567048337028\n" +
                "GX101204_1575287212256\n" +
                "GX230208_1569552989263\n" +
                "GX111002_1574923653040\n" +
                "GX111002_1574923653040\n" +
                "GX120044_1574489272415\n" +
                "GX111002_1574923653040\n" +
                "GX120044_1574489272415\n" +
                "GX230208_1569552989263\n" +
                "GX190232_1567248586478\n" +
                "GX230208_1569552989263\n" +
                "GB171006_1567552333680\n" +
                "GB171006_1567552333680\n" +
                "GX101228_1575558836375\n" +
                "GX090216_1558980223073\n" +
                "GX090216_1558980223073\n" +
                "GX090216_1558980223073\n" +
                "GB171006_1567552333680\n" +
                "GX101228_1575558836375\n" +
                "GX101228_1575558836375\n" +
                "GB171006_1567552333680\n" +
                "GB160006_1566462830665\n" +
                "GX221014_1574563315696\n" +
                "GB171006_1567552333680\n" +
                "GX221008_1567668843835\n" +
                "GX090216_1558980223073\n" +
                "GB171006_1567552333680\n" +
                "GB171006_1567552333680\n" +
                "GX101228_1575558836375\n" +
                "GB171006_1567552333680\n" +
                "GB160006_1566462830665\n" +
                "GB160006_1566462830665\n" +
                "GX101228_1575558836375\n" +
                "GX221008_1567668843835\n" +
                "GB171006_1567552333680\n" +
                "GX090216_1558980223073\n" +
                "GB171006_1567552333680\n" +
                "GX221008_1567668843835\n" +
                "GB171006_1567552333680\n" +
                "GB171006_1567552333680\n" +
                "GB160006_1566462830665\n" +
                "GB171006_1567552333680\n" +
                "GX221014_1574563315696\n" +
                "GB171006_1567552333680\n" +
                "GB160006_1566462830665\n" +
                "GB171006_1567552333680\n" +
                "GB160006_1566462830665\n" +
                "GX090216_1558980223073\n" +
                "GX221008_1567668843835\n" +
                "GB171006_1567552333680\n" +
                "GX101228_1575558836375\n" +
                "GE191032_1573201536192\n" +
                "GX180232_1569331002105\n" +
                "GX030252_1575445954972\n" +
                "GN010010_1559028131692\n" +
                "GX030252_1571209516354\n" +
                "GX180232_1574903867685\n" +
                "GN010002_1564561106644\n" +
                "GX150244_1571542128345\n" +
                "GX130002_1559284306089\n" +
                "GB170010_1559088781189\n" +
                "GX101204_1574215957413\n" +
                "GB170180_1567128863517\n" +
                "GX101204_1567401986043\n" +
                "GX101204_1567401986043\n" +
                "GX180232_1574903867685\n" +
                "GX130002_1559284306089\n" +
                "GX101204_1507685191294\n" +
                "GN010002_1566976025093\n" +
                "GX180232_1569331002105\n" +
                "GX030252_1571209516354\n" +
                "GA070180_1558489441519\n" +
                "GX101204_1574215957413\n" +
                "GX130002_1559284306089\n" +
                "GX030252_1575445954972\n" +
                "GB170010_1559088781189\n" +
                "GX150244_1571542128345\n" +
                "ZC050002_1551664300437\n" +
                "GE191032_1573201536192\n" +
                "GB170180_1567128863517\n" +
                "GX101204_1567401986043\n" +
                "GB170180_1567128863517\n" +
                "GX101204_1507685191294\n" +
                "GN010002_1566269481591\n" +
                "GN010002_1566269481591\n" +
                "GN010002_1575378142511\n" +
                "GX101204_1574215957413\n" +
                "GN010002_1575378142511\n" +
                "GN010002_1564561106644\n" +
                "ZC050002_1551664300437\n" +
                "GX101204_1567401986043\n" +
                "GX150244_1571542128345\n" +
                "GX150244_1571542128345\n" +
                "GX130002_1559284306089\n" +
                "GB170010_1559088781189\n" +
                "GX180232_1574903867685\n" +
                "GX180232_1574903867685\n" +
                "GX101204_1507685191294\n" +
                "GB170180_1567128863517\n" +
                "GA070180_1558489441519\n" +
                "GN010002_1575378142511\n" +
                "ZC050002_1551664300437\n" +
                "GX180232_1569331002105\n" +
                "GX180232_1574903867685\n" +
                "GB170010_1559088781189\n" +
                "GN010002_1575378142511\n" +
                "GX130002_1559284306089\n" +
                "GB170180_1567128863517\n" +
                "GB170010_1559088781189\n" +
                "GN010010_1564571808601\n" +
                "GX150244_1571542128345\n" +
                "GX101204_1574215957413\n" +
                "GX101204_1507685191294\n" +
                "GX130002_1559284306089\n" +
                "GX180232_1569331002105\n" +
                "GN010002_1566976025093\n" +
                "ZC050002_1551664300437\n" +
                "GX222004_1586048521940\n" +
                "GB170010_1574389873458\n" +
                "GX190232_1584690087143\n" +
                "GX101204_1574307255163\n" +
                "GX090216_1585098333899\n" +
                "GX101204_1582801043074\n" +
                "GC140186_1584323544368\n" +
                "GX101204_1585811704723\n" +
                "GX101204_1586245633790\n" +
                "GB200004_1584512437636\n" +
                "GX190258_1585887225456\n" +
                "GB200004_1584512437636\n" +
                "GC140186_1584323544368\n" +
                "GX261006_1577342731599\n" +
                "GX090216_1585466621910\n" +
                "GX190210_1573193674647\n" +
                "GX190258_1585904237799\n" +
                "GX180002_1575075269674\n" +
                "GX101204_1586166882431\n" +
                "GB170010_1574389873458\n" +
                "I_1585633491149\n" +
                "GX180232_1574858017172\n" +
                "GB170180_1582797578458\n" +
                "I_1585633491149\n" +
                "GX101204_1586245633790\n" +
                "GC140186_1584334779575\n" +
                "GX160118_1583889393468\n" +
                "GX222004_1586048521940\n" +
                "GX222004_1586048521940\n" +
                "GX220002_1568806109108\n" +
                "GX261006_1577342731599\n" +
                "GX190232_1584690087143\n" +
                "GC140186_1584323544368\n" +
                "GX261006_1577342731599\n" +
                "GX220002_1584066423513\n" +
                "GX190258_1585887225456\n" +
                "GX160118_1583889393468\n" +
                "GB200004_1584512437636\n" +
                "GX090216_1585098333899\n" +
                "GX160118_1583889393468\n" +
                "GC140186_1584323544368\n" +
                "I_1585633491149\n" +
                "GX180002_1569206265770\n" +
                "GX101204_1582801043074\n" +
                "GX090216_1585466621910\n" +
                "GC140186_1584323544368\n" +
                "GX261006_1577342731599\n" +
                "GX190258_1585904237799\n" +
                "GX101204_1582801043074\n" +
                "GX180232_1574858017172\n" +
                "GX090216_1585193683453\n" +
                "GX130002_1583295669478\n" +
                "GX101204_1582801043074\n" +
                "GC140186_1575444555154\n" +
                "GX190232_1585753446516\n" +
                "GX190258_1585887225456\n" +
                "GX222004_1586048521940\n" +
                "GX220002_1584066423513\n" +
                "GX101204_1586166882431\n" +
                "GX190210_1573193674647\n" +
                "GX130002_1583295669478\n" +
                "GX090216_1585098333899\n" +
                "GB170180_1582797578458\n" +
                "GX220002_1584066423513\n" +
                "GB170180_1582797578458\n" +
                "GX190232_1585753446516\n" +
                "GX101204_1586245633790\n" +
                "GX180232_1574858017172\n" +
                "I_1585633491149\n" +
                "GX101204_1586166882431\n" +
                "GX190232_1584690087143\n" +
                "GX101204_1586166882431\n" +
                "GX220002_1584066423513\n" +
                "GX100056_1577926861437\n" +
                "GX220002_1584066423513\n" +
                "GB170010_1574389873458\n" +
                "I_1585633491149\n" +
                "GX190232_1584690087143\n" +
                "GX190232_1585753446516\n" +
                "GX101204_1574307255163\n" +
                "GX030252_1574762161328\n" +
                "GX100056_1577926861437\n" +
                "GX101204_1574307255163\n" +
                "GB170010_1571900923098\n" +
                "GX090216_1585098333899\n" +
                "GB170180_1582797578458\n" +
                "GX220002_1568806109108\n" +
                "GX090216_1585098333899\n" +
                "GX190258_1585887225456\n" +
                "GB170010_1582210128833\n" +
                "GC140186_1575444555154\n" +
                "GX190232_1584690087143\n" +
                "GX190258_1585887225456\n" +
                "GX180002_1569206265770\n" +
                "GX101204_1574307255163\n" +
                "GX222004_1586048521940\n" +
                "GB200004_1584512437636\n" +
                "GB170010_1571900923098\n" +
                "GC140186_1584323544368\n" +
                "GX180002_1575075269674\n" +
                "GX190258_1585904237799\n" +
                "GX090216_1585193683453\n" +
                "GB170180_1582797578458\n" +
                "GX220002_1568806109108\n" +
                "GC140186_1584334779575\n" +
                "GB170010_1582210128833\n" +
                "GX090216_1585466621910\n" +
                "GC140186_1584334779575\n" +
                "GB170010_1574389873458\n" +
                "GX190258_1585887225456\n" +
                "GX261006_1577342731599\n" +
                "GX101204_1574307255163\n" +
                "GX190258_1585904237799\n" +
                "GC140186_1584334779575\n" +
                "GB170010_1571900923098\n" +
                "GB200004_1584512437636\n" +
                "GX100056_1577926861437\n" +
                "GX261006_1577342731599\n" +
                "GX101204_1586166882431\n" +
                "GX190232_1585753446516\n" +
                "GX130002_1583295669478\n" +
                "GX101204_1585811704723\n" +
                "GX101204_1586245633790\n" +
                "GX180002_1569206265770\n" +
                "GX101204_1585811704723\n" +
                "GX261006_1577342731599\n" +
                "GX190232_1584690087143\n" +
                "GX101204_1582801043074\n" +
                "GX090216_1585466621910\n" +
                "GX160118_1583889393468\n" +
                "GB170180_1582797578458\n" +
                "GX130002_1583295669478\n" +
                "GB170010_1582210128833\n" +
                "GX090216_1585466621910\n" +
                "GX101204_1585811704723\n" +
                "GX190258_1585904237799\n" +
                "GC140186_1584334779575\n" +
                "GX160118_1583889393468\n" +
                "GB170010_1582210128833\n" +
                "GX090216_1585466621910\n" +
                "GX090216_1585098333899\n" +
                "GC140186_1584334779575\n" +
                "GX130002_1583295669478\n" +
                "GX180232_1574858017172\n" +
                "GX090216_1585193683453\n" +
                "GB170010_1571900923098\n" +
                "GX220002_1584066423513\n" +
                "GX030252_1574762161328\n" +
                "GX180002_1569206265770\n" +
                "GX190258_1585904237799\n" +
                "GX190232_1585753446516\n" +
                "GX190232_1585753446516\n" +
                "GX180002_1575075269674\n" +
                "GX090216_1585193683453\n" +
                "GX090216_1585193683453\n" +
                "GX101204_1586166882431\n" +
                "GX220002_1568806109108\n" +
                "GX101204_1574307255163\n" +
                "GB170010_1582210128833\n" +
                "GX090216_1585193683453\n" +
                "GX160118_1583889393468\n" +
                "GB170010_1574389873458\n" +
                "GX100056_1577926861437\n" +
                "GX101204_1585811704723\n" +
                "GB170010_1571900923098\n" +
                "GX101204_1586245633790";
        String str1 = str.replace('\n',',');
        String[] strArr = str1.split(",");
        for(int i = 0; i < strArr.length;i++){
            strArr[i] = "\'" + strArr[i] + "\',";
            System.out.print(strArr[i]);
        }


    }
}
