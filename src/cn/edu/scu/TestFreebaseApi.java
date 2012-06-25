package cn.edu.scu;

import com.freebase.api.*;
import com.freebase.json.JSON;

import static com.freebase.json.JSON.a;
import static com.freebase.json.JSON.o;

public class TestFreebaseApi {

    public static void main(String args[]) {
        Freebase freebase = Freebase.getFreebase();
        JSON query = o(
                "id", null,
                "type", "/film/film",
                "name", "Blade Runner",
                "directed_by", a(o(
                "id", null,
                "name", null)));
        JSON result=freebase.mqlread(query);
        //System.out.println(result);
        // {
        //  "result":{"id":"\/en\/blade_runner",
        //           "directed_by":[{"id":"\/en\/ridley_scott","name":"Ridley Scott"}],
        //           "name":"Blade Runner",
        //           "type":"\/film\/film" },
        //
        //           "status":"200 OK",
        //           "code":"\/api\/status\/ok",
        //           "transaction_id":"cache;cache02.p01.sjc1:8101;2011-10-11T14:24:26Z;0066"
        // }
        //change again
        //just install svn
        DecodeResearch dr=new DecodeResearch();
        //dr.ImplyContainerFactoryInterface(result.toJSONString());
        dr.TryFinderClass(result.toJSONString(),"name");
    }
}
