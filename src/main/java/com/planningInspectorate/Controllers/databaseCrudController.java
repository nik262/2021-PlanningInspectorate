package com.planningInspectorate.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.planningInspectorate.ServiceLayer.databaseCrudLogic;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.planningInspectorate.DataLayer.CompleteRecord;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Arrays;

@RestController
@RequestMapping(path="api/v1/dbCrud")
public class databaseCrudController {


    private CompleteRecord ConvertArrayToObject(String[] input) {
        // if no id provided aka length == 7
        if (input.length == 7){
            String[] temp = new String[8];
            temp[0] = "";
            System.arraycopy(input, 0, temp, 1, 7);
            input = temp;
        }
        CompleteRecord record = new CompleteRecord(
                input[0],
                input[1],
                input[2],
                input[3],
                input[4],
                input[5],
                input[6],
                input[7]
        );
        return record;
    }

    //reference to servicelayer logic
    private final databaseCrudLogic databaseCrudLogic;

    //dependency injection instantiating  databasecrudlogic^^
    @Autowired
    public databaseCrudController(com.planningInspectorate.ServiceLayer.databaseCrudLogic databaseCrudLogic) {
        this.databaseCrudLogic = databaseCrudLogic;
    }

    @GetMapping("/getRecords/{searchTerm}")
    public CompleteRecord[] GetRecords(@PathVariable String[] searchTerm){

        return databaseCrudLogic.GetRecords(searchTerm);
    }

    @GetMapping("/getRecordPin/{recordId}")
    public String GetRecordPin(@PathVariable String recordId) throws NoSuchAlgorithmException {
        return databaseCrudLogic.GetRecordOneTimePin(recordId);
    }

    @PutMapping("/editRecords")
    public boolean EditRecord(@RequestBody String[] data){
        return databaseCrudLogic.EditRecord(ConvertArrayToObject(data));
    }

    @PostMapping("/addRecord")
    public boolean AddRecord(@RequestBody String[] data){
        return databaseCrudLogic.AddRecord(ConvertArrayToObject(data));
    }

    @DeleteMapping("/deleteRecord/{id}")
    public boolean DeleteRecord(@PathVariable String id){
         return databaseCrudLogic.DeleteRecord(id);
    }

    @GetMapping("/verifyOTP/{pin}")
    public boolean VerifyOTP(@PathVariable String pin){
        return databaseCrudLogic.VerifyOTP(pin);
    }

    @GetMapping("/getRecordFromOTP/{pin}")
    public CompleteRecord GetRecordFromOTP(@PathVariable String pin){
        return databaseCrudLogic.GetRecordFromOtp(pin);
    }

    @PutMapping("/updateOtp")
    public boolean updateOtp(@RequestBody String[] data){
        databaseCrudLogic.updateOtp(data);
        return true;
    }
}
