(function(window, document, $, undefined) {
        "use strict";
        $(function() {

                if ($('#chartjs_line').length) {
                    var ctx = document.getElementById('chartjs_line').getContext('2d');

                    var myChart = new Chart(ctx, {
                            type: 'line',

                            data: {
                                labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                                datasets: [{
                                    label: 'Almonds',
                                    data: [12, 19, 3, 17, 6, 3, 7],

                                    backgroundColor: "rgba(89, 105, 255,0.5)",
                                    borderColor: "rgba(89, 105, 255,0.7)",
                                    borderWidth: 2
                                }, {
                                    label: 'Cashew',
                                    data: [2, 29, 5, 5, 2, 3, 10],
                                    backgroundColor: "rgba(255, 64, 123,0.5)",
                                    borderColor: "rgba(255, 64, 123,0.7)",
                                    borderWidth: 2
                                }]

                            },
                            options: {
                                legend: {
                                    display: true,
                                    position: 'bottom',

                                    labels: {
                                        fontColor: '#71748d',
                                        fontFamily: 'Circular Std Book',
                                        fontSize: 14,
                                    }
                                },

                                scales: {
                                    xAxes: [{
                                        ticks: {
                                            fontSize: 14,
                                            fontFamily: 'Circular Std Book',
                                            fontColor: '#71748d',
                                        }
                                    }],
                                    yAxes: [{
                                        ticks: {
                                            fontSize: 14,
                                            fontFamily: 'Circular Std Book',
                                            fontColor: '#71748d',
                                        }
                                    }]
                                }
                            }
                        


                    });
            }


            if ($('#chartjs_bar').length) {
                var ctx = document.getElementById("chartjs_bar").getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ["Completed", "Defined", "Unelaborated", "Ready to Ship", "In Progress", ],
                        datasets: [{
                            label: 'Vineeth',
                            data: [1, 1, 1, 2, 1],
                           backgroundColor: "rgba(89, 105, 255,0.5)",
                                    borderColor: "rgba(89, 105, 255,0.7)",
                            borderWidth: 2
                        }, {
                            label: 'Dhana',
                            data: [1, 0, 0, 3, 0],
                           backgroundColor: "rgba(255, 64, 123,0.5)",
                                    borderColor: "rgba(255, 64, 123,0.7)",
                            borderWidth: 2
                        }, {
                            label: 'Shikha',
                            data: [1, 1, 0, 0, 0],
                           backgroundColor: "rgba(33, 147, 58,0.5)",
                                    borderColor: "rgba(33, 147, 58,0.7)",
                            borderWidth: 2
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{

                            }]
                        },
                             legend: {
                        display: true,
                        position: 'bottom',

                        labels: {
                            fontColor: '#71748d',
                            fontFamily: 'Circular Std Book',
                            fontSize: 14,
                        }
                    },

                    scales: {
                        xAxes: [{
                            ticks: {
                                fontSize: 14,
                                fontFamily: 'Circular Std Book',
                                fontColor: '#71748d',
                            }
                        }],
                        yAxes: [{
                            ticks: {
                                fontSize: 14,
                                fontFamily: 'Circular Std Book',
                                fontColor: '#71748d',
                            }
                        }]
                    }
                }

                    
                });
            }
			
			  if ($('#chartjs_bar1').length) {
                var ctx = document.getElementById("chartjs_bar1").getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ["Completed", "Defined", "Unelaborated", "Ready to Ship", "In Progress", "Total"],
                        datasets: [{
                            label: 'Elmeadwy Ahmed',
                            data: [1, 2, 1, 1, 1, 6],
                           backgroundColor: "rgba(145, 48, 219,0.5)",
                                    borderColor: "rgba(145, 48, 219,0.7)",
                            borderWidth: 2
                        }, {
                            label: 'Nasr Charbel',
                            data: [2, 0, 0, 4, 0, 6],
                           backgroundColor: "rgba(48, 74, 219,0.5)",
                                    borderColor: "rgba(48, 74, 219,0.7)",
                            borderWidth: 2
                        }]
                    },
                    options: {
                        scales: {
                            yAxes: [{

                            }]
                        },
                             legend: {
                        display: true,
                        position: 'bottom',

                        labels: {
                            fontColor: '#71748d',
                            fontFamily: 'Circular Std Book',
                            fontSize: 14,
                        }
                    },

                    scales: {
                        xAxes: [{
                            ticks: {
                                fontSize: 14,
                                fontFamily: 'Circular Std Book',
                                fontColor: '#71748d',
                            }
                        }],
                        yAxes: [{
                            ticks: {
                                fontSize: 14,
                                fontFamily: 'Circular Std Book',
                                fontColor: '#71748d',
                            }
                        }]
                    }
                }

                    
                });
            }

            if ($('#chartjs_radar').length) {
                var ctx = document.getElementById("chartjs_radar");
                var myChart = new Chart(ctx, {
                    type: 'radar',
                    data: {
                        labels: ["M", "T", "W", "T", "F", "S", "S"],
                        datasets: [{
                            label: 'Almonds',
                           backgroundColor: "rgba(89, 105, 255,0.5)",
                                    borderColor: "rgba(89, 105, 255,0.7)",
                            data: [12, 19, 3, 17, 28, 24, 7],
                            borderWidth: 2
                        }, {
                            label: 'Cashew',
                             backgroundColor: "rgba(255, 64, 123,0.5)",
                                    borderColor: "rgba(255, 64, 123,0.7)",
                            data: [30, 29, 5, 5, 20, 3, 10],
                            borderWidth: 2
                        }]
                    },
                    options: {
                       
                             legend: {
                        display: true,
                        position: 'bottom',

                        labels: {
                            fontColor: '#71748d',
                            fontFamily: 'Circular Std Book',
                            fontSize: 14,
                        }
                    },

                    
                }

                });
            }


            if ($('#chartjs_polar').length) {
                var ctx = document.getElementById("chartjs_polar").getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'polarArea',
                    data: {
                        labels: ["M", "T", "W", "T", "F", "S", "S"],
                        datasets: [{
                            backgroundColor: [
                                "#5969ff",
                                "#ff407b",
                                "#25d5f2",
                                "#ffc750",
                                "#2ec551",
                                "#7040fa",
                                "#ff004e"
                            ],
                            data: [12, 19, 3, 17, 28, 24, 7]
                        }]
                    },
                    options: {
                        
                             legend: {
                        display: true,
                        position: 'bottom',

                        labels: {
                            fontColor: '#71748d',
                            fontFamily: 'Circular Std Book',
                            fontSize: 14,
                        }
                    },

                    
                }
                });
            }


            if ($('#chartjs_pie').length) {
                var ctx = document.getElementById("chartjs_pie").getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'pie',
                    data: {
                        labels: ["M", "T", "W", "T", "F", "S", "S"],
                        datasets: [{
                            backgroundColor: [
                               "#5969ff",
                                "#ff407b",
                                "#25d5f2",
                                "#ffc750",
                                "#2ec551",
                                "#7040fa",
                                "#ff004e"
                            ],
                            data: [12, 19, 3, 17, 28, 24, 7]
                        }]
                    },
                    options: {
                           legend: {
                        display: true,
                        position: 'bottom',

                        labels: {
                            fontColor: '#71748d',
                            fontFamily: 'Circular Std Book',
                            fontSize: 14,
                        }
                    },

                    
                }
                });
            }


            if ($('#chartjs_doughnut').length) {
                var ctx = document.getElementById("chartjs_doughnut").getContext('2d');
                var myChart = new Chart(ctx, {
                    type: 'doughnut',
                    data: {
                        labels: ["M", "T", "W", "T", "F", "S", "S"],
                        datasets: [{
                            backgroundColor: [
                                 "#5969ff",
                                "#ff407b",
                                "#25d5f2",
                                "#ffc750",
                                "#2ec551",
                                "#7040fa",
                                "#ff004e"
                            ],
                            data: [12, 19, 3, 17, 28, 24, 7]
                        }]
                    },
                    options: {

                             legend: {
                        display: true,
                        position: 'bottom',

                        labels: {
                            fontColor: '#71748d',
                            fontFamily: 'Circular Std Book',
                            fontSize: 14,
                        }
                    },

                    
                }

                });
            }


        });

})(window, document, window.jQuery);