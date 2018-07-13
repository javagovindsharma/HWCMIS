/*var app1 = angular.module('myAppsection', []);
app1.controller('myCtrlSection', function($scope, $http) {
    $http.get("Question?method=setSection").then(function (response) {
    	$scope.sections=['--SELECT--'];
    	$scope.sections = response.data;
    });
});
    
    
    
var app2 = angular.module('myAppquestion', []);
app2.controller('myCtrlQuestion', function($scope, $http) {   
    $http.get("Question?method=setQuestion").then(function (response) {
    	$scope.questions=['--SELECT--'];
    	$scope.questions = response.data;
    });
}); 
    
var app3 = angular.module('myAppservice', []);
app3.controller('myCtrlService', function($scope, $http) { 
    $http.get("Question?method=setService").then(function (response) {
    	$scope.services=['--SELECT--'];
    	$scope.services = response.data;
    });
});

var app4 = angular.module('myAppsubservice', []);
app4.controller('myCtrlSubService', function($scope, $http) { 
    $http.get("Question?method=setSubService").then(function (response) {
    	$scope.subservices=['--SELECT--'];
    	$scope.subservices = response.data;
    });
});*/