angular.module('app').service('ModalService', ['$uibModal',
    function ($uibModal) {
        var xthis = {
            createInstance: function (size, templateUrl) {
                return $uibModal.open({
                    templateUrl: templateUrl,
                    controller: 'ModalController',
                    size: size,
                    windowClass : 'show'
                });
            },
            error: {
                open: function () {
                    this.modal = xthis.createInstance('sm', '/angular/app/modal-window/modal-error.html');
                }, close: function () {
                    this.modal.close();
                }
            }}
        return xthis;
    }]).controller('ModalController', function ($scope, $uibModalInstance) {
    $scope.ok = function () {
        $uibModalInstance.close($scope.selected.item);
    };
    $scope.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});