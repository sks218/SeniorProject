function buildChart(house, start, end){
    $.get( // request
        //"http://192.168.1.13:3000/public",//home
        //"http://128.180.103.176:3000/query",//lehigh
        "http://localhost:3000/query",
        {
            house: house,
            start: start,
            end: end
            //limit: limit,
            //limit2: limit + 2
        },
        function(data) {
            //console.log(data);
            /*zingchart.render({ // generate chart
                "id": "Aggregate",
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
                            "text":"Aggregate",
                            //"line-color":"#000088",
                            "marker":{
                                //"border-color":"#000088",
                                //"background-color":"#000088"
                            }
                        }
                    ]
                }
            });*/
            //if (data["PDTime"].length > 0){
            zingchart.render({ // generate chart
                "id": "PredDisag",
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
                            "text":"Aggregate"
                        }/*,
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
                        }*/
                    ]
                }
            });
            //}
            //if (data["GTDTime"].length > 0){
            /*zingchart.render({ // generate chart
                "id": "GTDisag",
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
                            "text":"Aggregate"
                        },
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
            });*/
            //}
        }
    );
}

var aggInfo = "Description of aggregated data.";
var predInfo = "Description of predictive set.";
var gtInfo = "Description of ground-truth set.";

window.onload = function(){ // run automatically for this test
    console.log($("#buildingName").val());
    console.log($("#recordCount").val());
    $("#submit").click(function(){
        //var records = $("#recordCount").val();
        //records = parseInt(records);
        //console.log(records);
        //records = Math.abs(records || 100);
        //console.log(records);
        var start = $("#startDate").val();
        start = new Date(start);
        start = start.getTime() / 1000;
        start = start || 0;
        var end = $("#endDate").val();
        end = new Date(end);
        end = end.getTime() / 1000;
        end = end || 2147483647;
        console.log(start);
        console.log(end);
        $("#PredDisag").html("");
        $("#GTDisag").html("");
        $("#Aggregate").html("");
       // if (start && end){
            buildChart($("#buildingName").find("option:selected").attr("id"),start, end);
            $("#houseLabel").html("Analysis: "+$("#buildingName").val());
        //}
        //$("#aggDesc").html(aggInfo);
        //$("#predDesc").html(predInfo);
        //$("#gtDesc").html(gtInfo);
        
    });
    /*$.get(
        "http://128.180.100.138:3000/testTimeStampConverter",
        {},
        function(){

        }
    );*/
    //buildChart();
};