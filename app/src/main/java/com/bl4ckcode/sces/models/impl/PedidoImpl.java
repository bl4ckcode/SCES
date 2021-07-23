package com.bl4ckcode.sces.models.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.bl4ckcode.sces.models.Cliente;
import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.ItensPedido;
import com.bl4ckcode.sces.models.Pedido;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pedido</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.impl.PedidoImpl#getCodigoPedido <em>Codigo Pedido</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.PedidoImpl#getDataPedido <em>Data Pedido</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.PedidoImpl#getClientes <em>Clientes</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.PedidoImpl#getItens_do_pedido <em>Itens do pedido</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PedidoImpl extends MinimalEObjectImpl.Container implements Pedido {
	/**
	 * The default value of the '{@link #getCodigoPedido() <em>Codigo Pedido</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodigoPedido()
	 * @generated
	 * @ordered
	 */
	protected static final String CODIGO_PEDIDO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodigoPedido() <em>Codigo Pedido</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodigoPedido()
	 * @generated
	 * @ordered
	 */
	protected String codigoPedido = CODIGO_PEDIDO_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataPedido() <em>Data Pedido</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataPedido()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_PEDIDO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataPedido() <em>Data Pedido</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataPedido()
	 * @generated
	 * @ordered
	 */
	protected String dataPedido = DATA_PEDIDO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClientes() <em>Clientes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClientes()
	 * @generated
	 * @ordered
	 */
	protected Cliente clientes;

	/**
	 * The cached value of the '{@link #getItens_do_pedido() <em>Itens do pedido</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItens_do_pedido()
	 * @generated
	 * @ordered
	 */
	protected EList<ItensPedido> itens_do_pedido;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PedidoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcommerceposPackage.Literals.PEDIDO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodigoPedido() {
		return codigoPedido;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodigoPedido(String newCodigoPedido) {
		String oldCodigoPedido = codigoPedido;
		codigoPedido = newCodigoPedido;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PEDIDO__CODIGO_PEDIDO, oldCodigoPedido, codigoPedido));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDataPedido() {
		return dataPedido;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataPedido(String newDataPedido) {
		String oldDataPedido = dataPedido;
		dataPedido = newDataPedido;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PEDIDO__DATA_PEDIDO, oldDataPedido, dataPedido));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cliente getClientes() {
		return clientes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClientes(Cliente newClientes, NotificationChain msgs) {
		Cliente oldClientes = clientes;
		clientes = newClientes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PEDIDO__CLIENTES, oldClientes, newClientes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientes(Cliente newClientes) {
		if (newClientes != clientes) {
			NotificationChain msgs = null;
			if (clientes != null)
				msgs = ((InternalEObject)clientes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcommerceposPackage.PEDIDO__CLIENTES, null, msgs);
			if (newClientes != null)
				msgs = ((InternalEObject)newClientes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcommerceposPackage.PEDIDO__CLIENTES, null, msgs);
			msgs = basicSetClientes(newClientes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.PEDIDO__CLIENTES, newClientes, newClientes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ItensPedido> getItens_do_pedido() {
		if (itens_do_pedido == null) {
			itens_do_pedido = new EObjectContainmentWithInverseEList<ItensPedido>(ItensPedido.class, this, EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO, EcommerceposPackage.ITENS_PEDIDO__PEDIDO);
		}
		return itens_do_pedido;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getItens_do_pedido()).basicAdd(otherEnd, msgs);
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
			case EcommerceposPackage.PEDIDO__CLIENTES:
				return basicSetClientes(null, msgs);
			case EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO:
				return ((InternalEList<?>)getItens_do_pedido()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcommerceposPackage.PEDIDO__CODIGO_PEDIDO:
				return getCodigoPedido();
			case EcommerceposPackage.PEDIDO__DATA_PEDIDO:
				return getDataPedido();
			case EcommerceposPackage.PEDIDO__CLIENTES:
				return getClientes();
			case EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO:
				return getItens_do_pedido();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcommerceposPackage.PEDIDO__CODIGO_PEDIDO:
				setCodigoPedido((String)newValue);
				return;
			case EcommerceposPackage.PEDIDO__DATA_PEDIDO:
				setDataPedido((String)newValue);
				return;
			case EcommerceposPackage.PEDIDO__CLIENTES:
				setClientes((Cliente)newValue);
				return;
			case EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO:
				getItens_do_pedido().clear();
				getItens_do_pedido().addAll((Collection<? extends ItensPedido>)newValue);
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
			case EcommerceposPackage.PEDIDO__CODIGO_PEDIDO:
				setCodigoPedido(CODIGO_PEDIDO_EDEFAULT);
				return;
			case EcommerceposPackage.PEDIDO__DATA_PEDIDO:
				setDataPedido(DATA_PEDIDO_EDEFAULT);
				return;
			case EcommerceposPackage.PEDIDO__CLIENTES:
				setClientes((Cliente)null);
				return;
			case EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO:
				getItens_do_pedido().clear();
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
			case EcommerceposPackage.PEDIDO__CODIGO_PEDIDO:
				return CODIGO_PEDIDO_EDEFAULT == null ? codigoPedido != null : !CODIGO_PEDIDO_EDEFAULT.equals(codigoPedido);
			case EcommerceposPackage.PEDIDO__DATA_PEDIDO:
				return DATA_PEDIDO_EDEFAULT == null ? dataPedido != null : !DATA_PEDIDO_EDEFAULT.equals(dataPedido);
			case EcommerceposPackage.PEDIDO__CLIENTES:
				return clientes != null;
			case EcommerceposPackage.PEDIDO__ITENS_DO_PEDIDO:
				return itens_do_pedido != null && !itens_do_pedido.isEmpty();
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
		result.append(" (codigoPedido: ");
		result.append(codigoPedido);
		result.append(", dataPedido: ");
		result.append(dataPedido);
		result.append(')');
		return result.toString();
	}

} //PedidoImpl
