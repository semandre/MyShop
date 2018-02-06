var mainView =angular.module("mainView",[]);


// ------------------------------- MAIN VIEW --------------------------------
mainView.controller("mainViewCtrl",function ($scope,$http) {
    $scope.cartView='cart';
    $scope.isEmpty=true;
    $scope.categories=[];
   var cartItems= $scope.cartItems=JSON.parse(localStorage.getItem('cartItems')) || [];
    console.log($scope.cartItems);
    var isEmpty = cartItems.length>0 ? $scope.isEmpty=false : $scope.isEmpty=true;
    console.log(isEmpty);


    // $scope.displayClass="dNone";
    // $scope.openCart=function () {
    //     console.log($scope.cartItems);
    //     $scope.displayClass="dBlock";
    //     $scope.cartView=true;
    // };
    //
    // $scope.closeCart=function () {
    //     $scope.displayClass="dNone";
    //     console.log($scope.displayClass);
    // };
    $scope.checkout=function () {
        $scope.cartView='order';
       $http.post('/checkout',cartItems);
       localStorage.removeItem('cartItems');
    };



   var showItems = $http.get('/showItems');
   showItems.success(function (data) {
       $scope.items=data;
   });
   showItems.error(function (xhr) {
        console.log(xhr.status);
   });

   var showCategories =$http.get('/addProduct');
   showCategories.success(function (data) {
       $scope.categories=data;
   });
   
   $scope.addToCart=function () {
       var b=true;

       var cartItem=this.item;
       angular.forEach($scope.cartItems,function (cart) {
           console.log(cart);
           if (cart.id==cartItem.id) {
               var cQuant=parseInt(cart.quantity)+1;
               cart.quantity=cQuant;
               b=false;
           }
       });
       if (b) {
           this.item.quantity=1;
           $scope.cartItems.push(this.item);

       }
       localStorage.setItem('cartItems',JSON.stringify($scope.cartItems));
   };
   
   $scope.addOne=function () {
       var cartItem=this.item;
       angular.forEach($scope.cartItems,function (cart) {
           if (cart.id==cartItem.id) {
               var cQuant=parseInt(cart.quantity)+1;
               cart.quantity=cQuant;
           }
       });
       localStorage.setItem('cartItems',JSON.stringify($scope.cartItems));
   };
   
   $scope.removeOne=function () {
       var cartItem=this.item;
       angular.forEach($scope.cartItems,function (cart) {
           if (cart.id==cartItem.id) {
               var cQuant=parseInt(cart.quantity)-1;
               if (cQuant<=0) {
                   cQuant=1;
               }
               cart.quantity=cQuant;
           }
       })
       localStorage.setItem('cartItems',JSON.stringify($scope.cartItems));
   };


    $scope.remove=function(){
        // localStorage.removeItem('cartItems');
        var cartItem=this.item;
        for (var i = 0; i < $scope.cartItems.length; i++) {
            if ($scope.cartItems[i].id==cartItem.id) {
                $scope.cartItems.splice(i,1);
            }
        }
        localStorage.setItem('cartItems',JSON.stringify($scope.cartItems));

    };



});

//-------------------------- ADMINS VIEW --------------------------------
mainView.controller("adminsViewCtrl",function ($scope,$http) {
    $scope.items=[];
        // [{name:"Absolute", category:"Vodka",price:100,stock:34524,status:"enabled"},
        // {name:"Guinness", category:"Beer",price:57,stock:34524,status:"enabled"}];
    $scope.currentView="none";
    $scope.currentItem={};
    $scope.categories=[];
    $scope.orders=[];

    $scope.edit=function (item) {
        $scope.currentView="edit";
        $scope.currentItem=item;
    };

    $scope.showProducts=function () {
        $scope.currentView="products";
       var showItems =$http.get("/showItems");
        showItems.success(function (data) {
            $scope.items=data;
        })
    };

    $scope.addProduct=function () {
        $scope.currentView="add";
        $http.get("/addProduct").success(function (data) {
            $scope.categories=data;
        })
    };

    $scope.showOrders=function () {
        $scope.currentView="orders";
        $http.get("/showOrders").success(function (data) {
            console.log(data);
            $scope.orders=data;
        })
    };
    


});

//------------------------- PRODUCT VIEW -----------------------------
mainView.controller("viewProductCtrl",function ($scope,$http) {
    $scope.alcogol=JSON.parse(session.getAttribute('alcogol'));
    console.log($scope.alcogol);


});
