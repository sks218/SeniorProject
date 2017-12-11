var mysql = require('mysql');
var express = require('express');
var app = express();

var publicSet = {
	"House_1": {
		"Aggregate": "House_1_agg",
		"GroundTruth": "House_1_disag_gt",
		"Predictive": "House_1_disag_pred"
	},
	"House_2": {
		"Aggregate": "House_2_agg",
		"GroundTruth": "House_2_disag_gt",
		"Predictive": "House_2_disag_pred"
	}
}



// Create the connection to MySQL
/*var connection = mysql.createConnection({
	host: '18.221.205.109',//host: 'jdbc:mysql://lehighenergydata.cnzogex34uax.us-east-2.rds.amazonaws.com/',
	//port: 3306,
	user: 'sks218',
	password: 'lehigh17',
	database: 'LehighResidential',
	debug: true
});*/
var connection = null;

function setDataBase(db){
	connection = mysql.createConnection({
		host: '18.221.205.109',
		user: 'sks218',
		password: 'lehigh17',
		database: db,
		debug: true
	});
}

setDataBase("REDD");
var queryString = "";//'SELECT * from House_1 limit 5000';

// Start the server
var server = app.listen(3000, function () {
	//console.log(date2Unix("2011-04-29 23:08:26-04:00"));
	var port = server.address().port;
	console.log('Example app listening at %s', port);
});

// Configure our app to serve static files from the current directory
app.use(express.static('./'));

// Display `index.html` when `localhost:3000` is requested
app.get('/', function (req, res) {
	res.sendFile('./index.html', {root: './'});
	
});

/*var combinedDataSet = {
	AggTime: [],
	AggPower: [],

	PDTime: [],
	PDSockets: [],
	PDFridge: [],
	PDDishwasher: [],
	PDMicrowave: [],
	PDLight: [],

	GTDTime: [],
	GTDSockets: [],
	GTDFridge: [],
	GTDDishwasher: [],
	GTDMicrowave: [],
	GTDLight: []
};*/
var months = [
	0,
	30,
	58,
	30,
	31,
	30
]
function date2Unix(date){
	//2011-04-29 23:08:26-04:00
	console.log(date);
	var unix = 0;
	var year = parseInt(date.substring(0,4));
	var month = parseInt(date.substring(5,7));
	var day = parseInt(date.substring(8,10));
	var hour = parseInt(date.substring(11,13));
	var minute = parseInt(date.substring(14,16));
	var second = parseInt(date.substring(17,19));
	console.log(year);
	console.log(month);
	console.log(day);
	console.log(hour);
	console.log(minute);
	console.log(second);
	var mdays = 
	unix += (year-1970) * 31536000; // 365 * 24 * 60 * 60
	unix += 0;
	//unix = (second) + (minute * 60) + (hour * 3600) + (day * 86400) + (month * 2592000) + ((year - 1970) * 31536000);
	//console.log(unix);
	//return unix;
}

function timeConverter(UNIX_timestamp){
	var a = new Date(UNIX_timestamp * 1000);
	var months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
	var year = a.getFullYear();
	var month = months[a.getMonth()];
	var date = a.getDate();
	var hour = a.getHours();
	var min = a.getMinutes();
	var sec = a.getSeconds();
	var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec ;
	return time;
  }

app.get('/testTimeStampConverter', function(req, res){
	date2Unix("2017-11-26T21:32:01Z");
	date2Unix("2017-11-26 21:32:01-04:00");
	res.send({});
});

// Send all records when there's a GET request to `localhost:3000/test`
app.get('/query', function (req, res) {
	console.log('request from: '+req.ip);
	//console.log("received a get request with parameter: "+req.query.p1);
	var table = req.query.house;
	//var start = req.query.start;
	//var end = req.query.end;
	var limit = req.query.limit;
	//var limit2 = req.query.limit2;
	var combinedDataSet = {
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
	//queryString = "select * from "+table+" limit "+limit;
	//console.log(table);
	//console.log(tableSet[table]);
	//console.log(combinedDataSet);
	if (publicSet[table] != null){
		//setDataBase("REDD");
		connection.query("select * from "+publicSet[table]["Aggregate"]+" limit "+ limit, function(err, rows, fields) {
        	//if (err) throw err;
        	if (err){
        	    console.log("ERROR");
			}
			for(var n = 0; n < rows.length; n++){
				combinedDataSet["AggTime"].push(rows[n]["Time"]);
				combinedDataSet["AggPower"].push(parseFloat(rows[n]["Power"]));
			}
			connection.query("select * from "+publicSet[table]["Predictive"]+" limit "+limit, function(err, rows, fields) {
				//if (err) throw err;
				if (err){
					console.log("ERROR");
				}
				for(var n = 0; n < rows.length; n++){
					combinedDataSet["PDTime"].push(rows[n]["Time"]);
					combinedDataSet["PDSockets"].push(parseFloat(rows[n]["Sockets"]));
					combinedDataSet["PDFridge"].push(parseFloat(rows[n]["Fridge"]));
					combinedDataSet["PDDishwasher"].push(parseFloat(rows[n]["Dishwasher"]));
					combinedDataSet["PDMicrowave"].push(parseFloat(rows[n]["Microwave"]));
					combinedDataSet["PDLight"].push(parseFloat(rows[n]["Light"]));
				}
				connection.query("select * from "+publicSet[table]["GroundTruth"]+" limit "+limit, function(err, rows, fields) {
					//if (err) throw err;
					if (err){
						console.log("ERROR");
					}
					for(var n = 0; n < rows.length; n++){
						combinedDataSet["GTDTime"].push(rows[n]["Time"]);
						combinedDataSet["GTDSockets"].push(parseFloat(rows[n]["Sockets"]));
						combinedDataSet["GTDFridge"].push(parseFloat(rows[n]["Fridge"]));
						combinedDataSet["GTDDishwasher"].push(parseFloat(rows[n]["Dishwasher"]));
						combinedDataSet["GTDMicrowave"].push(parseFloat(rows[n]["Microwave"]));
						combinedDataSet["GTDLight"].push(parseFloat(rows[n]["Light"]));
					}
					//console.log("here it is");
					//console.log(combinedDataSet);
					//console.log("where is it");
					res.send(combinedDataSet);
					console.log("ding");
				});
			});
		});
	//console.log(combinedDataSet);
	}
	
	else{
		res.send(combinedDataSet);
	}
	
});



// Graceful shutdown handler 
var gracefulShutdown = function(){
	console.log("Received kill signal, shutting down gracefully.");
	// End MySQL connection
	connection.end(function() {
		console.log("Disconnected from MySQL.");
		server.close(function() {
			console.log("Closed out remaining connections.");
			process.exit()
		});
	});
	
	// If after 10 seconds, exit anyway
	setTimeout(function() {
		console.error("Could not close connections in time, forcefully shutting down");
		process.exit()
	}, 10*1000);
}

// Listen for TERM signal. e.g. kill 
process.on ('SIGTERM', gracefulShutdown);

// Listen for INT signal. e.g. Ctrl-C
process.on ('SIGINT', gracefulShutdown); 