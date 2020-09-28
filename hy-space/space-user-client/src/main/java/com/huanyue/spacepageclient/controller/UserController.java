package com.huanyue.spacepageclient.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huanyue.spacepageclient.entity.Result;
import com.huanyue.spacepageclient.entity.User;
import com.huanyue.spacepageclient.entity.YcjcEO;
import com.huanyue.spacepageclient.service.UserService;
import com.huanyue.spacepageclient.util.CsvUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("${apiPath}/user")
@Api(tags = {"用户"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/comparedDiff")
    @ApiOperation(value = "通过csv文件名遍历查找表数据")
    public Result comparedDiff(String path, HttpServletResponse response) throws IOException {
        userService.delValidate();
        Set<String> res = new HashSet<>();
        File file = new File(path);
        File[] files = file.listFiles();
        StringBuffer sb = new StringBuffer();
        for(File fl:files){
            String tableName = fl.getName().replaceAll(".csv","");
            String json = CsvUtil.getJSONFromFile(fl.getAbsolutePath(),",");
            userService.insertData(json,tableName);
            List<String> showZcbm = userService.queryZcbm(tableName);
            List<String> validateZcbm = userService.queryZcbmValidate(tableName);
            if(showZcbm.removeAll(validateZcbm)){
                res.addAll(showZcbm);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(String r:res){
            stringBuffer.append("'"+r+"',");
        }

        return new Result(1,"success",stringBuffer.toString());
    }


    @PostMapping("/byCsvZcfh")
    @ApiOperation(value = "通过csv文件名遍历查找表数据")
    public Result byCsvZcfh(String path, HttpServletResponse response) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();
        StringBuffer sb = new StringBuffer();
        for(File fl:files){
            String tableName = fl.getName().replaceAll(".csv","");
           /* List<Map<String,Object>> s = userService.getTestUser(tableName);
            Map<String,Object> mp = s.get(0);
            for(String key:mp.keySet()){
                String field = "private String " + key + ";";
                System.out.println(field);
            }*/
            String json = CsvUtil.getJSONFromFile(fl.getAbsolutePath(),",");




           // String json = getMapList(s);
            String repJson = json.replaceAll("\\\"","\\\\\"");
            String apd = "private static String "+tableName.toLowerCase()+" = \""+repJson+"\"; \n";
            System.out.println(apd);
            System.out.println();
            sb.append(apd);
        }
        File outFile = new File("F:\\out\\txt\\out.txt");
        if(!outFile.exists()){
            outFile.getParentFile().mkdir();
            outFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
        bos.write(sb.toString().getBytes("gbk"));
        bos.close();
        InputStream is = new FileInputStream(outFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"gbk"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"gbk"));
        response.setCharacterEncoding("gbk");
        response.setContentType("text/plain;charset=gbk");
        response.setHeader("Content-Disposition", "attachment; filename=" + "out.txt");
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = reader.read())!=-1){
            System.out.println((char) len);
            writer.write(len);
        }
        is.close();
        reader.close();
        writer.close();
        response.getOutputStream().close();


       /* ObjectMapper mapper = new ObjectMapper();
        GgcsCheckEO[] pp1 = mapper.readValue(json, GgcsCheckEO[].class);
        List<GgcsCheckEO> data = new ArrayList<>(Arrays.asList(pp1));
        System.out.println(data.size());*/

        return new Result(1,"success","");
    }

    @PostMapping("/readExcelInsertData")
    @ApiOperation(value = "通过csv文件名遍历查找表数据")
    public Result readExcelInsertData(String path, HttpServletResponse response)  {

        userService.readExcelInsertData(path);

       /* ObjectMapper mapper = new ObjectMapper();
        GgcsCheckEO[] pp1 = mapper.readValue(json, GgcsCheckEO[].class);
        List<GgcsCheckEO> data = new ArrayList<>(Arrays.asList(pp1));
        System.out.println(data.size());*/

        return new Result(1,"success","");
    }

    @PostMapping("/byCsvYcjc")
    @ApiOperation(value = "通过csv文件名遍历查找表数据")
    public Result byCsvYcjc(String path, HttpServletResponse response) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();
        StringBuffer sb = new StringBuffer();
        StringBuffer listAddBuffer = new StringBuffer();
        for(File fl:files){
            String tableName = fl.getName().replaceAll(".csv","");
           /* List<Map<String,Object>> s = userService.getTestUser(tableName);
            Map<String,Object> mp = s.get(0);
            for(String key:mp.keySet()){
                String field = "private String " + key + ";";
                System.out.println(field);
            }*/
            String json = CsvUtil.getJSONFromFile(fl.getAbsolutePath(),",");
            // String json = getMapList(s);
            String repJson = json.replaceAll("\\\"","\\\\\"");
            ObjectMapper mapper = new ObjectMapper();
            YcjcEO[] pp1 = mapper.readValue(json, YcjcEO[].class);
            List<YcjcEO> data = new ArrayList<>(Arrays.asList(pp1));
            for(YcjcEO ycjcEO:data){
                String method = "  private ParamEO "+ycjcEO.getYcbm()+"(){\n" +
                        "        ParamEO paramEO = getYcParam(\""+ycjcEO.getYcEname()+"\");\n" +
                        "        if(paramEO!=null){\n" +
                        "            paramEO.setYcbm(\""+ycjcEO.getYcbm()+"\");\n" +
                        "            paramEO.setPdyj(\""+ycjcEO.getPdyj()+"\");\n" +
                        "        }\n" +
                        "        return paramEO;\n" +
                        "    }\n";
                String listAdd = "ycjcList.add("+ycjcEO.getYcbm()+"());";
                listAddBuffer.append(listAdd).append("\n");
                sb.append(method).append("\n");
            }



           /* String apd = "private static String "+tableName.toLowerCase()+" = \""+repJson+"\"; \n";
            System.out.println(apd);
            System.out.println();
            sb.append(apd);*/
        }
        File outFile = new File("F:\\out\\txt\\out.txt");
        if(!outFile.exists()){
            outFile.getParentFile().mkdir();
            outFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
        bos.write(sb.toString().getBytes("gbk"));
        bos.close();
        InputStream is = new FileInputStream(outFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"gbk"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(),"gbk"));
        response.setCharacterEncoding("gbk");
        response.setContentType("text/plain;charset=gbk");
        response.setHeader("Content-Disposition", "attachment; filename=" + "out.txt");
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = reader.read())!=-1){
            System.out.println((char) len);
            writer.write(len);
        }
        is.close();
        reader.close();
        writer.close();
        response.getOutputStream().close();


       /* ObjectMapper mapper = new ObjectMapper();
        GgcsCheckEO[] pp1 = mapper.readValue(json, GgcsCheckEO[].class);
        List<GgcsCheckEO> data = new ArrayList<>(Arrays.asList(pp1));
        System.out.println(data.size());*/

        return new Result(1,"success","");
    }




    @PostMapping("/byTableNameZcfh")
    @ApiOperation(value = "传入库名列表直接返回")
    public Result byTableNameZcfh(String path) throws IOException {
        String[] names = path.split(",");
        StringBuffer sb = new StringBuffer();
        for(String tableName:names){
            List<Map<String,Object>> s = userService.getTestUser(tableName);
            String json = getMapList(s);
            String repJson = json.replaceAll("\\\"","\\\\\"");
            String apd = "private static String "+tableName.toLowerCase()+" = \""+repJson+"\"; \n";
            System.out.println(apd);
            System.out.println();
            sb.append(apd);
        }
        File outFile = new File("F:\\out\\txt\\out.txt");
        if(!outFile.exists()){
            outFile.getParentFile().mkdir();
            outFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
        bos.write(sb.toString().getBytes("gbk"));
        bos.close();

       /* ObjectMapper mapper = new ObjectMapper();
        GgcsCheckEO[] pp1 = mapper.readValue(json, GgcsCheckEO[].class);
        List<GgcsCheckEO> data = new ArrayList<>(Arrays.asList(pp1));
        System.out.println(data.size());*/

        return new Result(1,"success","");
    }

    @PostMapping("/query")
    @ApiOperation(value = "orcl")
    public Result query(String tableName) throws IOException {
        List<Map<String,Object>> maps = userService.getTestUser(tableName);
        List<String> keys = new LinkedList<>();
        for(int i = 0; i < maps.size();i++){
            Map<String,Object> m = maps.get(i);
            String ename = m.get("FIELDNAME").toString();

                if(keys.contains(ename)){
                    System.out.println(ename);
                }else{
                    keys.add(ename);
                }

            System.out.println("end");
        }

       /* ObjectMapper mapper = new ObjectMapper();
        GgcsCheckEO[] pp1 = mapper.readValue(json, GgcsCheckEO[].class);
        List<GgcsCheckEO> data = new ArrayList<>(Arrays.asList(pp1));
        System.out.println(data.size());*/

        return new Result(1,"success","");
    }


    public static void main(String [] args){
        List<String> list1 = new ArrayList<>(Arrays.asList("KA,KB".split(",")));
        List<String> list2 = new ArrayList<>(Arrays.asList("KA,KC".split(",")));
        if(list1.removeAll(list2)){
            for(String l1:list1){
                System.out.println(l1);
            }
            for(String l2:list2){
                System.out.println(l2);
            }
        }
    }

    public static String getMapList(List<Map<String,Object>> mapList) {

        Map<String,String> stringMap = new HashMap<>();
        //map的格式：{level=1, customItem=a}
        for (Map<String, Object> map : mapList) {
            //values的格式：[1, a]
            Collection<Object> values = map.values();//获取所有的值
            //valueList的格式：[1, a]
            List<Object> valueList = new ArrayList<>(values);
            //添加stringMap，键和值
            stringMap.put(valueList.get(0)+"",valueList.get(1)+"");
        }
        //将stringMap转换成json字符串
        String str = JSON.toJSONString(mapList);
        return str;
    }

}
