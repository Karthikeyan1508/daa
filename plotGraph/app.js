google.charts.load('current', { packages: ['corechart', 'line'] });
google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {

  var data = new google.visualization.DataTable();
  data.addColumn('number', 'X');
  data.addColumn('number', 'Time');

  /* This part is to be replaced after the execution of Java Program */

  data.addRows([[500, 410900], [1000, 255000], [1500, 265200], [2000, 279200], [2500, 279000], [3000, 334500], [3500, 497100], [4000, 457900], [4500, 549400]]);
  
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