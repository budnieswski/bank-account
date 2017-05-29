Wooddy Wooddy!
===================

**First thing to do is ENABLE BIOS Virtualization**

**Than run this codes =P**

 - sudo apt install virtualbox
 - sudo apt install vagrant
 - git clone https://github.com/madeiramadeirabr/wooddy.git
 - cd wooddy
 - vagrant up
 - vagrant ssh
 	- sudo su
 	- yum install php56-php-pecl-redis.x86_64
 	- yum install redis
 	- chkconfig redis on
 	- rm -rf /etc/nginx/conf.d/default.conf
 	- vim /etc/nginx/conf.d/default.conf
 	- [Paste this code](#nginx-defaultconf).
 	- ESC :wq
 	- CTRL+Shift+D (2x)
 - vagrant reload

----------

> **Tip:** Store your git settings!
```
git config --global user.email "YOUR-GITHUB@EMAIL.COM"
git config --global user.name "FIRSTNAME LASTNAME"
git config credential.helper store
```

----------

NGINX default.conf
-------------------
```
server {
    listen 80;
    server_name dev.madeiramadeira.com.br;
    root /var/www/madeira;
    client_max_body_size 20M;

    gzip on;
    gzip_disable "msie6";

    gzip_vary on;
    gzip_proxied any;
    gzip_comp_level 6;
    gzip_buffers 16 8k;
    gzip_http_version 1.1;
    gzip_min_length 256;
    gzip_types text/plain text/css application/json application/x-javascript text/xml application/xml application/xml+rss text/javascript application/vnd.ms-fontobject application/x-font-ttf font/opentype image/svg+xml image/x-icon;

    set $http_x_device "desktop";
    if ($http_user_agent ~* "(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino") {
        set $http_x_device "mobile";
    }


    location ~ (^/cat/cadastro.php|^/partner|^/finalizar-compra.php|^/b/|^/public_core|^/__sess.php|^/carregaCnpj.php|^/cadastro.php|/endereco_auto.php|^/getcidades.php|^/fechamento.php|^/fc-core/|^/login.php|^/assets/|^/areavip/|sair.php|pagamento.php|carrinho.php|^/neemu/|^/skin/|^/portal/|^/presente.php) {
            rewrite ^/fc-core/(.*)      /$1 break;
            proxy_set_header            X-Real-IP             $remote_addr;
            proxy_set_header            X-Forwarded-For       $proxy_add_x_forwarded_for;
            proxy_pass                  http://127.0.0.1:8081;
            break;
    }

    location ~ (/sitemkplace|/stc).*\.(css|jpg|jpeg|gif|css|png|js|ico|html|swf|jsb)$ {
            try_files $uri /sitemkplace$uri =404;
            access_log off;
            expires max;
    }

    ######################################################################################
    rewrite /rex/v1/(.*)                           /rex/v1/trunk.php?$1 break;
    rewrite /buzz/v1/(.+)                          /buzz/v1/index.php?$1 break;
    rewrite /api/(.+)                              /api/index.php?$1 break;

    rewrite /project1/(.+)                          /project1/index.php?$1 break;


    rewrite /buzz/v2/(.+)                          /buzz/v2/trunk.php?$1 break;
    rewrite /buzz/v3/(.+)                          /buzz/v3/trunk.php?$1 break;
    rewrite /cross/v1/(.+)                         /cross/v1/trunk.php?$1 break;
    rewrite /andy/v1/(.+)                          /andy/v1/index.php?$1 break;
    ######################################################################################
    rewrite /admm/static(.*)                       /admm/static/$1 break;
    rewrite /admm(.*)                              /admm/index.php break;

    ######################################################################################
    # WOODDY
    location / {
            root   /var/www/madeira;
            index  index.php index.html index.htm;
    }

    rewrite \-([0-9]+).html?(.*)                   /index.php?id_product=$1&$2 break;     # PRODUCTS
    rewrite /static/(.*)                           /static/$1 break;                      # STATIC FILES
    rewrite  /ajax/(.*)                         /index.php?get_params=$1 last;
    if ( $uri !~ (^/cat/cadastro.php|^/partner|^/finalizar-compra.php|^/b/|^/public_core|^/__sess.php|^/carregaCnpj.php|^/cadastro.php|^/endereco_auto.php|^/getcidades.php|^/fechamento.php|^/fc-core/|login.php|^/assets/|^/areavip/|sair.php|pagamento.php|carrinho.php|^/neemu/|^/skin/|^/portal/|^/presente.php) ) {
            rewrite ((.+)[/]?)+?                   /index.php break;                      # DEPARTMENTS/CATEGORIES
    }
    ######################################################################################
    # NGINX
    location ~ \.php$ {
            fastcgi_param  HTTP_X_DEVICE $http_x_device;
            fastcgi_param  SCRIPT_FILENAME  $document_root$fastcgi_script_name;
            fastcgi_pass   127.0.0.1:9000;
            fastcgi_index  index.php;
            include        fastcgi_params;
    }
}

server {
    listen 443;
    server_name dev.madeiramadeira.com.br; 
    root /var/www/madeira-fc-core;

    location ~ .* {
            proxy_pass                  http://127.0.0.1:8081;
    }
}
```