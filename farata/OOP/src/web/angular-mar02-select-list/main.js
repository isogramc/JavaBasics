//jquery compoent
function NgChosen(elementRef) {
  this.items = ['First', 'Second', 'Third'];
  this.selectedValue = 'Second';
  var _this = this;
  
  //bind chosen after angular has completed since chosen creates new dom 
  //elements and hides the source node. 
  //this soulution does not respond to changes in items collection
  setTimeout(function(){
    var el = elementRef.domElement.children[0];
    $(el)
      .chosen()
      .on('change', _this.setValue);
  },0);
  
  this.setValue = function(e, params){
    _this.selectedValue = params.selected;
  };
  
}

NgChosen.annotations = [
    new angular.ComponentAnnotation({
        selector: 'jq-chosen',
        injectors: [angular.ElementRef]
    }),
    new angular.ViewAnnotation({
        directives: [angular.NgFor],
        template: '<select>' +
            '<option *ng-for="#item of items" [value]="item" [selected]="item == selectedValue">{{item}} option</option>' +
            '</select>' +
        '<h4> selected value: {{selectedValue}}</h4>'
    })
];

NgChosen.parameters = [[angular.ElementRef]];


//app compoent
function AppComponent() {
}
AppComponent.annotations = [
    new angular.ComponentAnnotation({
        selector: 'my-app'
    }),
    new angular.ViewAnnotation({
        template: '<h1>Select an option</h1> <jq-chosen></jq-chosen>',
        directives: [NgChosen]
    })
];

//bootstrap
document.addEventListener('DOMContentLoaded', function() {
    angular.bootstrap(AppComponent);
});