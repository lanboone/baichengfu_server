## 20200330
alter table tb_appuser ADD token varchar(32) Default NULL COMMENT  'app登录token';

## 20200401
alter table tb_appuser ADD wxapp_openid varchar(50) Default NULL COMMENT  '微信登录绑定的openid';

## 20200402
alter table tb_manager ADD sys_phone varchar(32) Default NULL COMMENT  '管理员手机号';