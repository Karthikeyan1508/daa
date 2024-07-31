google.charts.load('current', { packages: ['corechart', 'line'] });
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

  var data = new google.visualization.DataTable();
  data.addColumn('number', 'X');
  data.addColumn('number', 'Time');

  /* This part is to be replaced after the execution of Java Program */

  data.addRows([[500, 131400], [1000, 143700], [1500, 113900], [2000, 142200], [2500, 192900], [3000, 224500], [3500, 269500], [4000, 299500], [4500, 342200]]);
  
  /* --- */

  var options = {
    hAxis: {
      title: 'Time'
    },
    vAxis: {
      title: 'Input'
    },
    height: window.innerHeight / 1.5
  };

  var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

  chart.draw(data, options);
}