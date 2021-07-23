package com.bl4ckcode.sces.models;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @generated
 * @see com.bl4ckcode.sces.models.EcommerceposPackage
 */
public interface EcommerceposFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    EcommerceposFactory eINSTANCE = com.bl4ckcode.sces.models.impl.EcommerceposFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Cliente</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Cliente</em>'.
     * @generated
     */
    Cliente createCliente();

    /**
     * Returns a new object of class '<em>Pedido</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Pedido</em>'.
     * @generated
     */
    Pedido createPedido();

    /**
     * Returns a new object of class '<em>Categoria</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Categoria</em>'.
     * @generated
     */
    Categoria createCategoria();

    /**
     * Returns a new object of class '<em>Produto</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Produto</em>'.
     * @generated
     */
    Produto createProduto();

    /**
     * Returns a new object of class '<em>Itens Pedido</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return a new object of class '<em>Itens Pedido</em>'.
     * @generated
     */
    ItensPedido createItensPedido();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the package supported by this factory.
     * @generated
     */
    EcommerceposPackage getEcommerceposPackage();

} //EcommerceposFactory
