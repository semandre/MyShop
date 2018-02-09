var mainView =angular.module("mainView",[]);


// ------------------------------- MAIN VIEW --------------------------------
mainView.controller("mainViewCtrl",function ($scope,$http) {
    $scope.cartView='cart';
    // $scope.isEmpty=true;
    $scope.isAlcEnabled=false;
    $scope.categories=[];
   var cartItems= $scope.cartItems=JSON.parse(localStorage.getItem('cartItems')) || [];
    $scope.cartItems.length>0 ? $scope.isEmpty=false : $scope.isEmpty=true;
    $scope.focused=false;

    $scope.focus=function () {
        $scope.focused=true;
    };
    $scope.blur=function () {
        $scope.focused=false;
    };
    setTimeout($scope.blur,2000);
    $http.get('/findCities').success(function (data) {
        $scope.cities=data;
            // [{cityName:"львів"},{cityName:"тернопіль"}];
    });




    $scope.checkout=function () {
        $scope.cartView='order';
        console.log(cartItems);
       $http.post('/checkout',$scope.cartItems);
       localStorage.removeItem('cartItems');
    };



   var showItems = $http.get('/showItems');
   showItems.success(function (data) {

       $scope.items=data;
       angular.forEach($scope.items,function (cart) {
           $scope.isAlcEnabled=false;
           console.log(cart);
           if (cart.status==='disabled') {
               // $scope.isAlcEnabled=true;
           }
       });
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
       $scope.cartItems=JSON.parse(localStorage.getItem('cartItems')) || [];
        $scope.cartItems.length>0 ? $scope.isEmpty=false : $scope.isEmpty=true;
       console.log($scope.isEmpty);
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
       });
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
        $scope.cartItems=JSON.parse(localStorage.getItem('cartItems')) || [];
        $scope.cartItems.length>0 ? $scope.isEmpty=false : $scope.isEmpty=true;


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
    $scope.value='value';




    angular.forEach($scope.cities,function (city) {
        if (cart.id==cartItem.id) {
            var cQuant=parseInt(cart.quantity)+1;
            cart.quantity=cQuant;
            b=false;
        }
    });

    $scope.edit=function (item) {
        $http.get('/addProduct')
        .success(function (data) {
            $scope.categories=data;
        });
        $scope.currentView="edit";
        $scope.currentItem=item;
    };

    $scope.showProducts=function () {
        $scope.currentView="products";
       var showItems =$http.get("/showItems");
        showItems.success(function (data) {
            console.log(data);
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

    $scope.addCategory=function () {
        $scope.currentView="category";
    };

    $scope.addNewCategory=function (category) {
        console.log(category);
        $http.post('/addCategory',category);
    };

    $scope.addCity=function () {
        $scope.currentView="city";
    };
    $scope.addNewCity=function (city) {
        console.log(city);
        $http.post('/addCity',city).success(function (data) {
            console.log(data.message);
            $scope.msg=data.message;
        });
    };



    $scope.editItem=function (item) {
        console.log(item);
        $scope.currentView='products';
        $http.post('/editItem',item).success(function (data) {
            console.log(data);
            $scope.items=data;
        })
    };

    $scope.deleteItem=function (item) {
        console.log(item);
        $http.post('/deleteItem',item.id).success(function (data) {
            $scope.items=data;
        });
        $scope.currentView='products';
    };

    $scope.sendOrder=function (order) {
        console.log(order.sessionId);
        $http.post('/sendOrder',order.sessionId).success(function (data) {
            $scope.orders=data;
        })
    }
    


});

//------------------------- PRODUCT VIEW -----------------------------
mainView.controller("viewProductCtrl",function ($scope,$http) {
    $scope.alcogol=JSON.parse(session.getAttribute('alcogol'));
    console.log($scope.alcogol);


});
