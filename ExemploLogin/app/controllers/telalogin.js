// Arguments passed into this controller can be accessed via the `$.args` object directly or:
var args = $.args;

var dados =[ 
{title: 'Santa Cruz', divisao:1},
{title: 'Sport', divisao:1},
{title: 'Náutico', divisao:2},
{title: 'Ibis', divisao:4},
];


$.myTableView.data = dados;

function close(){
	$.telalogin.close();
}

