package vn.thodev.model.order;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import vn.thodev.model.AbstractEntity;
import vn.thodev.model.authentication.User;
import vn.thodev.model.cashbook.PaymentMethodType;
import vn.thodev.model.inventory.Docket;
import vn.thodev.model.waybill.Waybill;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order extends AbstractEntity<Long> {
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT")
    private Integer status;

    @Column(name = "to_name", nullable = false)
    private String toName;

    @Column(name = "to_phone", nullable = false)
    private String toPhone;

    @Column(name = "to_address", nullable = false)
    private String toAddress;

    @Column(name = "to_ward_name", nullable = false)
    private String toWardName;

    @Column(name = "to_district_name", nullable = false)
    private String toDistrictName;

    @Column(name = "to_province_name", nullable = false)
    private String toProvinceName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_cancellation_reason_id")
    private OrderCancellationReason orderCancellationReason;

    @Column(name = "note")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_resource_id", nullable = false)
    private OrderResource orderResource;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderVariant> orderVariants = new HashSet<>();

    @Column(name = "total_amount", nullable = false, columnDefinition = "DECIMAL(15,5)")
    private BigDecimal totalAmount;

    @Column(name = "tax", nullable = false, columnDefinition = "DECIMAL(15,5)")
    private BigDecimal tax;

    @Column(name = "shipping_cost", nullable = false, columnDefinition = "DECIMAL(15,5)")
    private BigDecimal shippingCost;

    @Column(name = "total_pay", nullable = false, columnDefinition = "DECIMAL(15,5)")
    private BigDecimal totalPay;

    @OneToOne(mappedBy = "order")
    private Waybill waybill;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Docket> dockets = new ArrayList<>();

    @Column(name = "payment_method_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethodType;

    @Column(name = "payment_status", nullable = false, columnDefinition = "TINYINT")
    private Integer paymentStatus;

    @Column(name = "paypal_order_id")
    private String paypalOrderId;

    @Column(name = "paypal_order_status")
    private String paypalOrderStatus;

}
