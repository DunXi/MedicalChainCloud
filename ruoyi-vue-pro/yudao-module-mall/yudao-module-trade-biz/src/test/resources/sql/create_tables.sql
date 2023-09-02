CREATE TABLE IF NOT EXISTS "trade_order" (
     "id" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY,
     "no" varchar NOT NULL,
     "type" int NOT NULL,
     "terminal" int NOT NULL,
     "user_id" bigint NOT NULL,
     "user_ip" varchar NOT NULL,
     "user_remark" varchar,
     "status" int NOT NULL,
     "product_count" int NOT NULL,
     "cancel_type" int,
     "remark" varchar,
     "pay_status" bit NOT NULL,
     "pay_time" datetime,
     "finish_time" datetime,
     "cancel_time" datetime,
     "original_price" int NOT NULL,
     "order_price" int NOT NULL,
     "discount_price" int NOT NULL,
     "delivery_price" int NOT NULL,
     "adjust_price" int NOT NULL,
     "pay_price" int NOT NULL,
     "pay_order_id" bigint,
     "pay_channel_code" varchar,
     "delivery_template_id" bigint,
     "logistics_id" bigint,
     "logistics_no" varchar,
     "delivery_status" smallint NOT NULL,
     "delivery_time" datetime,
     "receive_time" datetime,
     "receiver_name" varchar NOT NULL,
     "receiver_mobile" varchar NOT NULL,
     "receiver_area_id" int NOT NULL,
     "receiver_post_code" int,
     "receiver_detail_address" varchar NOT NULL,
     "after_sale_status" int NOT NULL,
     "refund_price" int NOT NULL,
     "coupon_id" bigint NOT NULL,
     "coupon_price" int NOT NULL,
     "point_price" int NOT NULL,
     "creator" varchar DEFAULT '',
     "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
     "updater" varchar DEFAULT '',
     "update_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     "deleted" bit NOT NULL DEFAULT FALSE,
     PRIMARY KEY ("id")
) COMMENT '交易订单表';

CREATE TABLE IF NOT EXISTS "trade_order_item" (
      "id" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY,
      "user_id" bigint NOT NULL,
      "order_id" bigint NOT NULL,
      "spu_id" bigint NOT NULL,
      "spu_name" varchar NOT NULL,
      "sku_id" bigint NOT NULL,
      "properties" varchar,
      "pic_url" varchar,
      "count" int NOT NULL,
      "original_price" int NOT NULL,
      "original_unit_price" int NOT NULL,
      "discount_price" int NOT NULL,
      "pay_price" int NOT NULL,
      "order_part_price" int NOT NULL,
      "order_divide_price" int NOT NULL,
      "after_sale_status" int NOT NULL,
      "creator" varchar DEFAULT '',
      "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
      "updater" varchar DEFAULT '',
      "update_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
      "deleted" bit NOT NULL DEFAULT FALSE,
      PRIMARY KEY ("id")
) COMMENT '交易订单明细表';

CREATE TABLE IF NOT EXISTS "trade_after_sale" (
    "id" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    "no" varchar NOT NULL,
    "status" int NOT NULL,
    "type" int NOT NULL,
    "way" int NOT NULL,
    "user_id" bigint NOT NULL,
    "apply_reason" varchar NOT NULL,
    "apply_description" varchar,
    "apply_pic_urls" varchar,
    "order_id" bigint NOT NULL,
    "order_no" varchar NOT NULL,
    "order_item_id" bigint NOT NULL,
    "spu_id" bigint NOT NULL,
    "spu_name" varchar NOT NULL,
    "sku_id" bigint NOT NULL,
    "properties" varchar,
    "pic_url" varchar,
    "count" int NOT NULL,
    "audit_time" varchar,
    "audit_user_id" bigint,
    "audit_reason" varchar,
    "refund_price" int NOT NULL,
    "pay_refund_id" bigint,
    "refund_time" varchar,
    "logistics_id" bigint,
    "logistics_no" varchar,
    "delivery_time" varchar,
    "receive_time" varchar,
    "receive_reason" varchar,
    "creator" varchar DEFAULT '',
    "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updater" varchar DEFAULT '',
    "update_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    "deleted" bit NOT NULL DEFAULT FALSE,
    PRIMARY KEY ("id")
) COMMENT '交易售后表';

CREATE TABLE IF NOT EXISTS "trade_after_sale_log" (
    "id" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    "user_id" bigint NOT NULL,
    "user_type" int NOT NULL,
    "after_sale_id" bigint NOT NULL,
    "order_id" bigint NOT NULL,
    "order_item_id" bigint NOT NULL,
    "before_status" int,
    "after_status" int NOT NULL,
    "content" varchar NOT NULL,
    "creator" varchar DEFAULT '',
    "create_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updater" varchar DEFAULT '',
    "update_time" datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    "deleted" bit NOT NULL DEFAULT FALSE,
    PRIMARY KEY ("id")
) COMMENT '交易售后日志';
