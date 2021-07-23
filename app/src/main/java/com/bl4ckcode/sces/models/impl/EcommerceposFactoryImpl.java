package com.bl4ckcode.sces.models.impl;

import com.bl4ckcode.sces.models.Categoria;
import com.bl4ckcode.sces.models.Cliente;
import com.bl4ckcode.sces.models.EcommerceposFactory;
import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.ItensPedido;
import com.bl4ckcode.sces.models.Pedido;
import com.bl4ckcode.sces.models.Produto;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcommerceposFactoryImpl extends EFactoryImpl implements EcommerceposFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EcommerceposFactory init() {
        try {
            EcommerceposFactory theEcommerceposFactory = (EcommerceposFactory) EPackage.Registry.INSTANCE.getEFactory(EcommerceposPackage.eNS_URI);
            if (theEcommerceposFactory != null) {
                return theEcommerceposFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EcommerceposFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EcommerceposFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case EcommerceposPackage.CLIENTE:
                return createCliente();
            case EcommerceposPackage.PEDIDO:
                return createPedido();
            case EcommerceposPackage.CATEGORIA:
                return createCategoria();
            case EcommerceposPackage.PRODUTO:
                return createProduto();
            case EcommerceposPackage.ITENS_PEDIDO:
                return createItensPedido();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cliente createCliente() {
        ClienteImpl cliente = new ClienteImpl();
        return cliente;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pedido createPedido() {
        PedidoImpl pedido = new PedidoImpl();
        return pedido;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Categoria createCategoria() {
        CategoriaImpl categoria = new CategoriaImpl();
        return categoria;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Produto createProduto() {
        ProdutoImpl produto = new ProdutoImpl();
        return produto;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItensPedido createItensPedido() {
        ItensPedidoImpl itensPedido = new ItensPedidoImpl();
        return itensPedido;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EcommerceposPackage getEcommerceposPackage() {
        return (EcommerceposPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EcommerceposPackage getPackage() {
        return EcommerceposPackage.eINSTANCE;
    }

} //EcommerceposFactoryImpl
