package com.bl4ckcode.sces.models.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.bl4ckcode.sces.models.Categoria;
import com.bl4ckcode.sces.models.Cliente;
import com.bl4ckcode.sces.models.EcommerceposFactory;
import com.bl4ckcode.sces.models.EcommerceposPackage;
import com.bl4ckcode.sces.models.ItensPedido;
import com.bl4ckcode.sces.models.Pedido;
import com.bl4ckcode.sces.models.Produto;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcommerceposPackageImpl extends EPackageImpl implements EcommerceposPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass clienteEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pedidoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itensPedidoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass produtoEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass categoriaEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.bl4ckcode.sces.models.EcommerceposPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private EcommerceposPackageImpl() {
        super(eNS_URI, EcommerceposFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link EcommerceposPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static EcommerceposPackage init() {
        if (isInited) return (EcommerceposPackage)EPackage.Registry.INSTANCE.getEPackage(EcommerceposPackage.eNS_URI);

        // Obtain or create and register package
        EcommerceposPackageImpl theEcommerceposPackage = (EcommerceposPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EcommerceposPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EcommerceposPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theEcommerceposPackage.createPackageContents();

        // Initialize created meta-data
        theEcommerceposPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theEcommerceposPackage.freeze();


        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(EcommerceposPackage.eNS_URI, theEcommerceposPackage);
        return theEcommerceposPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCliente() {
        return clienteEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_CPF() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Nome() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Endereco() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Estado() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Municipio() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Email() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Senha() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Id() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCliente_Telefone() {
        return (EAttribute)clienteEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPedido() {
        return pedidoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPedido_CodigoPedido() {
        return (EAttribute)pedidoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPedido_DataPedido() {
        return (EAttribute)pedidoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPedido_Clientes() {
        return (EReference)pedidoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPedido_Itens_do_pedido() {
        return (EReference)pedidoEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItensPedido() {
        return itensPedidoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItensPedido_Quantidade() {
        return (EAttribute)itensPedidoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItensPedido_Id() {
        return (EAttribute)itensPedidoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getItensPedido_Produto() {
        return (EReference)itensPedidoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getItensPedido_Pedido() {
        return (EReference)itensPedidoEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProduto() {
        return produtoEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProduto_CodigoProduto() {
        return (EAttribute)produtoEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProduto_Nome() {
        return (EAttribute)produtoEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProduto_Preco() {
        return (EAttribute)produtoEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProduto_QuantidadeEstoque() {
        return (EAttribute)produtoEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProduto_Cetgorias() {
        return (EReference)produtoEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCategoria() {
        return categoriaEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCategoria_Codigo() {
        return (EAttribute)categoriaEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCategoria_Nome() {
        return (EAttribute)categoriaEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EcommerceposFactory getEcommerceposFactory() {
        return (EcommerceposFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        clienteEClass = createEClass(CLIENTE);
        createEAttribute(clienteEClass, CLIENTE__CPF);
        createEAttribute(clienteEClass, CLIENTE__NOME);
        createEAttribute(clienteEClass, CLIENTE__ENDERECO);
        createEAttribute(clienteEClass, CLIENTE__ESTADO);
        createEAttribute(clienteEClass, CLIENTE__MUNICIPIO);
        createEAttribute(clienteEClass, CLIENTE__EMAIL);
        createEAttribute(clienteEClass, CLIENTE__SENHA);
        createEAttribute(clienteEClass, CLIENTE__ID);
        createEAttribute(clienteEClass, CLIENTE__TELEFONE);

        pedidoEClass = createEClass(PEDIDO);
        createEAttribute(pedidoEClass, PEDIDO__CODIGO_PEDIDO);
        createEAttribute(pedidoEClass, PEDIDO__DATA_PEDIDO);
        createEReference(pedidoEClass, PEDIDO__CLIENTES);
        createEReference(pedidoEClass, PEDIDO__ITENS_DO_PEDIDO);

        itensPedidoEClass = createEClass(ITENS_PEDIDO);
        createEAttribute(itensPedidoEClass, ITENS_PEDIDO__QUANTIDADE);
        createEAttribute(itensPedidoEClass, ITENS_PEDIDO__ID);
        createEReference(itensPedidoEClass, ITENS_PEDIDO__PRODUTO);
        createEReference(itensPedidoEClass, ITENS_PEDIDO__PEDIDO);

        produtoEClass = createEClass(PRODUTO);
        createEAttribute(produtoEClass, PRODUTO__CODIGO_PRODUTO);
        createEAttribute(produtoEClass, PRODUTO__NOME);
        createEAttribute(produtoEClass, PRODUTO__PRECO);
        createEAttribute(produtoEClass, PRODUTO__QUANTIDADE_ESTOQUE);
        createEReference(produtoEClass, PRODUTO__CETGORIAS);

        categoriaEClass = createEClass(CATEGORIA);
        createEAttribute(categoriaEClass, CATEGORIA__CODIGO);
        createEAttribute(categoriaEClass, CATEGORIA__NOME);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass(clienteEClass, Cliente.class, "Cliente", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCliente_CPF(), ecorePackage.getEString(), "CPF", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Nome(), ecorePackage.getEString(), "nome", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Endereco(), ecorePackage.getEString(), "endereco", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Estado(), ecorePackage.getEString(), "estado", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Municipio(), ecorePackage.getEString(), "municipio", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Email(), ecorePackage.getEString(), "email", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Senha(), ecorePackage.getEString(), "senha", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Id(), ecorePackage.getEInt(), "id", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCliente_Telefone(), ecorePackage.getEString(), "telefone", null, 1, 1, Cliente.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(pedidoEClass, Pedido.class, "Pedido", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPedido_CodigoPedido(), ecorePackage.getEString(), "codigoPedido", null, 1, 1, Pedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPedido_DataPedido(), ecorePackage.getEString(), "dataPedido", null, 1, 1, Pedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getPedido_Clientes(), this.getCliente(), null, "clientes", null, 1, 1, Pedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getPedido_Itens_do_pedido(), this.getItensPedido(), this.getItensPedido_Pedido(), "itens_do_pedido", null, 0, -1, Pedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(itensPedidoEClass, ItensPedido.class, "ItensPedido", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getItensPedido_Quantidade(), ecorePackage.getEDouble(), "quantidade", null, 1, 1, ItensPedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getItensPedido_Id(), ecorePackage.getEInt(), "id", null, 1, 1, ItensPedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getItensPedido_Produto(), this.getProduto(), null, "produto", null, 1, 1, ItensPedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getItensPedido_Pedido(), this.getPedido(), this.getPedido_Itens_do_pedido(), "pedido", null, 1, 1, ItensPedido.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(produtoEClass, Produto.class, "Produto", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProduto_CodigoProduto(), ecorePackage.getEString(), "codigoProduto", null, 1, 1, Produto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProduto_Nome(), ecorePackage.getEString(), "nome", null, 1, 1, Produto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProduto_Preco(), ecorePackage.getEDouble(), "preco", null, 1, 1, Produto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProduto_QuantidadeEstoque(), ecorePackage.getEDouble(), "quantidadeEstoque", null, 1, 1, Produto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getProduto_Cetgorias(), this.getCategoria(), null, "cetgorias", null, 1, 1, Produto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(categoriaEClass, Categoria.class, "Categoria", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCategoria_Codigo(), ecorePackage.getEString(), "codigo", null, 1, 1, Categoria.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCategoria_Nome(), ecorePackage.getEString(), "nome", null, 1, 1, Categoria.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //EcommerceposPackageImpl
