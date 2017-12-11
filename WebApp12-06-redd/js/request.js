var data = {
    "AggTime": [],
    "AggPower": [],
    "AggUnix": [],

    "PDTime": [],
    "PDSockets": [],
    "PDFridge": [],
    "PDDishwasher": [],
    "PDMicrowave": [],
    "PDLight": [],

    "GTDTime": [],
    "GTDSockets": [],
    "GTDFridge": [],
    "GTDDishwasher": [],
    "GTDMicrowave": [],
    "GTDLight": []
};

function buildChart(house, limit){
    $.get( // request
        //"http://192.168.1.13:3000/public",//home
        //"http://128.180.103.176:3000/query",//lehigh
        "http://localhost:3000/query",
        {
            house: house,
            //start: start,
            //end: end
            limit: limit
            //limit2: limit + 2
        },
        function(data1) {
            data = data1;
            render("pred");
        }
    );
}

function render(type){
    console.log(data);
    switch(type){
        case "pred":
            zingchart.render({ // generate chart
            "id": "theChart",
                "data":{
                    "background-color":"#dddddd",
                    "type":"line",
                    "title":{
                        "text":"Predictive Disaggregation"
                    },
                    "legend":{
                        "item":{
                            "border-color":"black",
                            "border-width":"1px",
                            "border-style":"solid",
                            "font-color":"black"
                        },
                        "draggable": true,
                        "drag-handler": "icon"
                    },
                    "scale-x": {
                        "labels":data["PDTime"],
                        "label":{
                            "text":"Time"
                        },
                        "zooming":true
                    },
                    "scale-y":{
                        "label":{
                            "text":"Power (Watts)"
                        },
                        "zooming":true
                    },
                    "preview":{
                        //"height":"30%"
                    },
                    "series":[
                        {
                            "values":data["PDSockets"],
                            "text":"Sockets"
                        },
                        {
                            "values":data["PDFridge"],
                            "text":"Fridge"
                        },
                        {
                            "values":data["PDDishwasher"],
                            "text":"Dishwasher"
                        },
                        {
                            "values":data["PDMicrowave"],
                            "text":"Microwave"
                        },
                        {
                            "values":data["PDLight"],
                            "text":"Light"
                        }
                    ]
                }
            });
            break;
        case "gt":
        zingchart.render({ // generate chart
            "id": "theChart",
                "data":{
                    "background-color":"#dddddd",
                    "type":"line",
                    "title":{
                        "text":"Ground-Truth Disaggregation"
                    },
                    "legend":{
                        "item":{
                            "border-color":"black",
                            "border-width":"1px",
                            "border-style":"solid",
                            "font-color":"black"
                        },
                        "draggable": true,
                        "drag-handler": "icon"
                    },
                    "scale-x": {
                        "labels":data["GTDTime"],
                        "label":{
                            "text":"Time"
                        },
                        "zooming":true
                    },
                    "scale-y":{
                        "label":{
                            "text":"Power (Watts)"
                        },
                        "zooming":true
                    },
                    "preview":{
                        //"height":"30%"
                    },
                    "series":[
                        {
                            "values":data["GTDSockets"],
                            "text":"Sockets"
                        },
                        {
                            "values":data["GTDFridge"],
                            "text":"Fridge"
                        },
                        {
                            "values":data["GTDDishwasher"],
                            "text":"Dishwasher"
                        },
                        {
                            "values":data["GTDMicrowave"],
                            "text":"Microwave"
                        },
                        {
                            "values":data["GTDLight"],
                            "text":"Light"
                        }
                    ]
                }
            });
            break;
        default:
        zingchart.render({ // generate chart
            "id": "theChart",
                "data":{
                    "background-color":"#dddddd",
                    "type":"line",
                    "title":{
                        "text":"Aggregate"
                    },
                    "legend":{
                        "item":{
                            "border-color":"black",
                            "border-width":"1px",
                            "border-style":"solid",
                            "font-color":"black"
                        },
                        "draggable": true,
                        "drag-handler": "icon"
                    },
                    "scale-x": {
                        "labels":data["AggTime"],
                        "label":{
                            "text":"Time"
                        },
                        "zooming":true
                    },
                    "scale-y":{
                        "label":{
                            "text":"Power (Watts)"
                        },
                        "zooming":true
                    },
                    "preview":{
                        //"height":"30%"
                    },
                    "series":[
                        {
                            "values":data["AggPower"],
                            "text":"Power"
                        }
                    ]
                }
            });
    }
    
}

var aggInfo = "Description of aggregated data.";
var predInfo = "Description of predictive set.";
var gtInfo = "Description of ground-truth set.";

window.onload = function(){ // run automatically for this test
    console.log($("#buildingName").val());
    console.log($("#recordCount").val());
    $("#submit").click(function(){
        var records = $("#recordCount").val();
        records = parseInt(records);
        console.log(records);
        records = Math.abs(records || 1000);
        console.log(records);
        /*var start = $("#startDate").val();
        start = new Date(start);
        start = start.getTime() / 1000;
        start = start || 0;
        var end = $("#endDate").val();
        end = new Date(end);
        end = end.getTime() / 1000;
        end = end || 2147483647;
        console.log(start);
        console.log(end);*/
        //$("#PredDisag").html("");
        //$("#GTDisag").html("");
        $("#theChart").html("");
       // if (start && end){
            buildChart($("#buildingName").find("option:selected").attr("id"), records);
            $("#houseLabel").html("Analysis: "+$("#buildingName").val());
            //render("pred")
        //}
        //$("#aggDesc").html(aggInfo);
        //$("#predDesc").html(predInfo);
        //$("#gtDesc").html(gtInfo);
        
    });
    $("#pred").click(function(){
        render("pred");
    });
    $("#gt").click(function(){
        render("gt");
    });
    $("#agg").click(function(){
        render("agg");
    });
    /*$.get(
        "http://128.180.100.138:3000/testTimeStampConverter",
        {},
        function(){

        }
    );*/
    //buildChart();
};