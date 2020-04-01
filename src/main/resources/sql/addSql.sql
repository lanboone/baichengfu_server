## 20200330
alter table tb_appuser ADD token varchar(32) Default NULL COMMENT  'app登录token';

## 20200401
alter table tb_appuser ADD wxapp_openid varchar(50) Default NULL COMMENT  '微信登录绑定的openid';