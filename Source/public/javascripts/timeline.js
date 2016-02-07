// -----------------------------------
// --------------- Controller for timeline page handling
// -----------------------------------
RESTApp.controller("TimelineCtrl", ['$scope', function($scope) {
    // ------------
    // ---- VARIABLES
    // ------------

    var lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec a diam lectus. Sed sit amet ipsum mauris. " +
        "Maecenas congue ligula ac quam viverra nec consectetur ante hendrerit. Donec et mollis dolor." +
        "Praesent et diam eget libero egestas mattis sit amet vitae augue. Nam tincidunt congue enim, " +
        "ut porta lorem lacinia consectetur. Donec ut libero sed arcu vehicula ultricies a non tortor." +
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    $scope.side = '';
    $scope.beginningRoute="ws://localhost:9000/";
    $scope.routeActorHome=$scope.beginningRoute+"searchHome";


    $scope.events = [{
        badgeClass: 'info',
        badgeIconClass: 'glyphicon-check',
        title: 'First heading',
        when: '11 hours ago via Twitter',
        content: 'Some awesome content.'
    }, {
        badgeClass: 'warning',
        badgeIconClass: 'glyphicon-credit-card',
        title: 'Second heading',
        when: '12 hours ago via Twitter',
        content: 'More awesome content.'
    }, {
        badgeClass: 'default',
        badgeIconClass: 'glyphicon-credit-card',
        title: 'Third heading',
        titleContentHtml: '<img class="img-responsive" src="http://www.freeimages.com/assets/183333/1833326510/wood-weel-1444183-m.jpg">',
        contentHtml: lorem,
        footerContentHtml: '<a href="">Continue Reading</a>'
    }];

    // ------------
    // ---- OPERATIONS ON TIMELINE
    // ------------

    $scope.addEvent = function() {
        $scope.events.push({
            badgeClass: 'info',
            badgeIconClass: 'glyphicon-check',
            title: 'First heading',
            when: '3 hours ago via Twitter',
            content: 'Some awesome content.'
        });

    };
    // optional: not mandatory (uses angular-scroll-animate)
    $scope.animateElementIn = function($el) {
        $el.removeClass('timeline-hidden');
        $el.addClass('bounce-in');
    };

    // optional: not mandatory (uses angular-scroll-animate)
    $scope.animateElementOut = function($el) {
        $el.addClass('timeline-hidden');
        $el.removeClass('bounce-in');
    };

    $scope.leftAlign = function() {
        $scope.side = 'left';
    };

    $scope.rightAlign = function() {
        $scope.side = 'right';
    };

    $scope.defaultAlign = function() {
        $scope.side = ''; // or 'alternate'
    };

    // ------------
    // ---- WEBSOCKET HANDLING
    // ------------
    function custom_sort(a, b) {
        return new Date(a.when).getTime() - new Date(b.when).getTime();
    }

    $scope.fillResultsTimeline = function(dataReceived) {
        for (var i in dataReceived) {
            $scope.events.push({
                badgeClass: 'info',
                badgeIconClass: 'glyphicon glyphicon-globe',
                contentHtml: dataReceived[i].description,
                title: dataReceived[i].title,
                when: dataReceived[i].date,
                footerContentHtml: '<a target="blank" href="'+dataReceived[i].link+'">En savoir plus</a>'
            });
        }
        $scope.events.sort(custom_sort);
    };

    $scope.handleSocketMessageTimeline = function(data, socket) {
        // -------- NOTIFICATIONS RECEIVED
        if (data.notifError) {
            console.log("Erreur -> "+data.error);
        }  else if (data.notifInfo) {
            console.log("Notification received -> " + data.notifInfo);

            // -------- DATA RECEIVED
        } else if (data.dataWikiCfp) {
            $scope.fillResultsTimeline(JSON.parse(data.dataWikiCfp));

            // -------- OTHER CASE
        } else {
            console.log("CASE NOT HANDLED, CLOSING SOCKET");
            socket.close();
        }
        $scope.$digest();
    };

    $scope.createMessageTimeline = function() {
        $scope.messageSent = {items : [
            {researchContent : "fetchConferencesTimeline"}
        ]};
    };

    //Handles search for timeline
    $scope.rechercheTimeline = function() {
        $scope.createMessageTimeline();
        $scope.socketJsonTimeline($scope.routeActorHome,$scope.messageSent); //Sending message to ActorRss through websocket
    };


    $scope.socketJsonTimeline = function(route, object) {
        var socket = new WebSocket(route);
        $scope.events = []; //Initializing scope results [tabInfoQ,tabIeee,tabDvptCom,tabWikicfp]

        // OPENING
        socket.onopen = function (event) {
            socket.send(JSON.stringify(object));
        };

        // RECEIVING
        socket.onmessage = function (event) {
            var data = JSON.parse(event.data);
            $scope.handleSocketMessageTimeline(data,socket);
        }
    };

    $scope.rechercheTimeline();

}]);
