package com.bl4ckcode.sces.models.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.ItensPedido;
import com.bl4ckcode.sces.models.Pedido;
import com.bl4ckcode.sces.models.Produto;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Itens Pedido</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ItensPedidoImpl#getQuantidade <em>Quantidade</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ItensPedidoImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ItensPedidoImpl#getProduto <em>Produto</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ItensPedidoImpl#getPedido <em>Pedido</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItensPedidoImpl extends MinimalEObjectImpl.Container implements ItensPedido {
    /**
     * The default value of the '{@link #getQuantidade() <em>Quantidade</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQuantidade()
     * @generated
     * @ordered
     */
    protected static final double QUANTIDADE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getQuantidade() <em>Quantidade</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQuantidade()
     * @generated
     * @ordered
     */
    protected double quantidade = QUANTIDADE_EDEFAULT;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final int ID_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected int id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getProduto() <em>Produto</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProduto()
     * @generated
     * @ordered
     */
    protected Produto produto;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItensPedidoImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcommerceposPackage.Literals.ITENS_PEDIDO;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQuantidade(double newQuantidade) {
        double oldQuantidade = quantidade;
        quantidade = newQuantidade;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.ITENS_PEDIDO__QUANTIDADE, oldQuantidade, quantidade));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId(int newId) {
        int oldId = id;
        id = newId;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.ITENS_PEDIDO__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProduto(Produto newProduto, NotificationChain msgs) {
        Produto oldProduto = produto;
        produto = newProduto;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcommerceposPackage.ITENS_PEDIDO__PRODUTO, oldProduto, newProduto);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProduto(Produto newProduto) {
        if (newProduto != produto) {
            NotificationChain msgs = null;
            if (produto != null)
                msgs = ((InternalEObject)produto).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcommerceposPackage.ITENS_PEDIDO__PRODUTO, null, msgs);
            if (newProduto != null)
                msgs = ((InternalEObject)newProduto).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcommerceposPackage.ITENS_PEDIDO__PRODUTO, null, msgs);
            msgs = basicSetProduto(newProduto, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.ITENS_PEDIDO__PRODUTO, newProduto, newProduto));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pedido getPedido() {
        if (eContainerFeatureID() != EcommerceposPackage.ITENS_PEDIDO__PEDIDO) return null;
        return (Pedido)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPedido(Pedido newPedido, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newPedido, EcommerceposPackage.ITENS_PEDIDO__PEDIDO, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPedido(Pedido newPedido) {
        if (newPedido != eInternalContainer() || (eContainerFeatureID() != EcommerceposPackage.ITENS_PEDIDO__PEDIDO && newPedido != null)) {
            if (EcoreUtil.isAncestor(this, newPedido))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newPedido != null)
                msgs = ((InternalEObject)newPedido).eInverseAdd(this, EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO, Pedido.class, msgs);
            msgs = basicSetPedido(newPedido, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.ITENS_PEDIDO__PEDIDO, newPedido, newPedido));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetPedido((Pedido)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EcommerceposPackage.ITENS_PEDIDO__PRODUTO:
                return basicSetProduto(null, msgs);
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                return basicSetPedido(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                return eInternalContainer().eInverseRemove(this, EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO, Pedido.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EcommerceposPackage.ITENS_PEDIDO__QUANTIDADE:
                return getQuantidade();
            case EcommerceposPackage.ITENS_PEDIDO__ID:
                return getId();
            case EcommerceposPackage.ITENS_PEDIDO__PRODUTO:
                return getProduto();
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                return getPedido();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EcommerceposPackage.ITENS_PEDIDO__QUANTIDADE:
                setQuantidade((Double)newValue);
                return;
            case EcommerceposPackage.ITENS_PEDIDO__ID:
                setId((Integer)newValue);
                return;
            case EcommerceposPackage.ITENS_PEDIDO__PRODUTO:
                setProduto((Produto)newValue);
                return;
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                setPedido((Pedido)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case EcommerceposPackage.ITENS_PEDIDO__QUANTIDADE:
                setQuantidade(QUANTIDADE_EDEFAULT);
                return;
            case EcommerceposPackage.ITENS_PEDIDO__ID:
                setId(ID_EDEFAULT);
                return;
            case EcommerceposPackage.ITENS_PEDIDO__PRODUTO:
                setProduto((Produto)null);
                return;
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                setPedido((Pedido)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EcommerceposPackage.ITENS_PEDIDO__QUANTIDADE:
                return quantidade != QUANTIDADE_EDEFAULT;
            case EcommerceposPackage.ITENS_PEDIDO__ID:
                return id != ID_EDEFAULT;
            case EcommerceposPackage.ITENS_PEDIDO__PRODUTO:
                return produto != null;
            case EcommerceposPackage.ITENS_PEDIDO__PEDIDO:
                return getPedido() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (quantidade: ");
        result.append(quantidade);
        result.append(", id: ");
        result.append(id);
        result.append(')');
        return result.toString();
    }

} //ItensPedidoImpl
