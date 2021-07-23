package com.bl4ckcode.sces.models;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.bl4ckcode.sces.models.EcommerceposFactory
 * @model kind="package"
 * @generated
 */
public interface EcommerceposPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "ecommercepos";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http:///rr/com.bl4ckcode.sces.models.ecore";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "rr.ecommercepos";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EcommerceposPackage eINSTANCE = com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl.init();

    /**
     * The meta object id for the '{@link com.bl4ckcode.sces.models.impl.ClienteImpl <em>Cliente</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.bl4ckcode.sces.models.impl.ClienteImpl
     * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getCliente()
     * @generated
     */
    int CLIENTE = 0;

    /**
     * The feature id for the '<em><b>CPF</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__CPF = 0;

    /**
     * The feature id for the '<em><b>Nome</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__NOME = 1;

    /**
     * The feature id for the '<em><b>Endereco</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__ENDERECO = 2;

    /**
     * The feature id for the '<em><b>Estado</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__ESTADO = 3;

    /**
     * The feature id for the '<em><b>Municipio</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__MUNICIPIO = 4;

    /**
     * The feature id for the '<em><b>Email</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__EMAIL = 5;

    /**
     * The feature id for the '<em><b>Senha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__SENHA = 6;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__ID = 7;

    /**
     * The feature id for the '<em><b>Telefone</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE__TELEFONE = 8;

    /**
     * The number of structural features of the '<em>Cliente</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE_FEATURE_COUNT = 9;

    /**
     * The number of operations of the '<em>Cliente</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLIENTE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.bl4ckcode.sces.models.impl.PedidoImpl <em>Pedido</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.bl4ckcode.sces.models.impl.PedidoImpl
     * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getPedido()
     * @generated
     */
    int PEDIDO = 1;

    /**
     * The feature id for the '<em><b>Codigo Pedido</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PEDIDO__CODIGO_PEDIDO = 0;

    /**
     * The feature id for the '<em><b>Data Pedido</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PEDIDO__DATA_PEDIDO = 1;

    /**
     * The feature id for the '<em><b>Clientes</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PEDIDO__CLIENTES = 2;

    /**
     * The feature id for the '<em><b>Itens do pedido</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PEDIDO__ITENS_DO_PEDIDO = 3;

    /**
     * The number of structural features of the '<em>Pedido</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PEDIDO_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Pedido</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PEDIDO_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.bl4ckcode.sces.models.impl.ItensPedidoImpl <em>Itens Pedido</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.bl4ckcode.sces.models.impl.ItensPedidoImpl
     * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getItensPedido()
     * @generated
     */
    int ITENS_PEDIDO = 2;

    /**
     * The feature id for the '<em><b>Quantidade</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITENS_PEDIDO__QUANTIDADE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITENS_PEDIDO__ID = 1;

    /**
     * The feature id for the '<em><b>Produto</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITENS_PEDIDO__PRODUTO = 2;

    /**
     * The feature id for the '<em><b>Pedido</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITENS_PEDIDO__PEDIDO = 3;

    /**
     * The number of structural features of the '<em>Itens Pedido</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITENS_PEDIDO_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Itens Pedido</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITENS_PEDIDO_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.bl4ckcode.sces.models.impl.ProdutoImpl <em>Produto</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.bl4ckcode.sces.models.impl.ProdutoImpl
     * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getProduto()
     * @generated
     */
    int PRODUTO = 3;

    /**
     * The feature id for the '<em><b>Codigo Produto</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO__CODIGO_PRODUTO = 0;

    /**
     * The feature id for the '<em><b>Nome</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO__NOME = 1;

    /**
     * The feature id for the '<em><b>Preco</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO__PRECO = 2;

    /**
     * The feature id for the '<em><b>Quantidade Estoque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO__QUANTIDADE_ESTOQUE = 3;

    /**
     * The feature id for the '<em><b>Cetgorias</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO__CETGORIAS = 4;

    /**
     * The number of structural features of the '<em>Produto</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO_FEATURE_COUNT = 5;

    /**
     * The number of operations of the '<em>Produto</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRODUTO_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.bl4ckcode.sces.models.impl.CategoriaImpl <em>Categoria</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.bl4ckcode.sces.models.impl.CategoriaImpl
     * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getCategoria()
     * @generated
     */
    int CATEGORIA = 4;

    /**
     * The feature id for the '<em><b>Codigo</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORIA__CODIGO = 0;

    /**
     * The feature id for the '<em><b>Nome</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORIA__NOME = 1;

    /**
     * The number of structural features of the '<em>Categoria</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORIA_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Categoria</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CATEGORIA_OPERATION_COUNT = 0;


    /**
     * Returns the meta object for class '{@link com.bl4ckcode.sces.models.Cliente <em>Cliente</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cliente</em>'.
     * @see com.bl4ckcode.sces.models.Cliente
     * @generated
     */
    EClass getCliente();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getCPF <em>CPF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>CPF</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getCPF()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_CPF();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getNome <em>Nome</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Nome</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getNome()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Nome();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getEndereco <em>Endereco</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Endereco</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getEndereco()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Endereco();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getEstado <em>Estado</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Estado</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getEstado()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Estado();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getMunicipio <em>Municipio</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Municipio</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getMunicipio()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Municipio();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getEmail <em>Email</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Email</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getEmail()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Email();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getSenha <em>Senha</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Senha</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getSenha()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Senha();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getId()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Id();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Cliente#getTelefone <em>Telefone</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Telefone</em>'.
     * @see com.bl4ckcode.sces.models.Cliente#getTelefone()
     * @see #getCliente()
     * @generated
     */
    EAttribute getCliente_Telefone();

    /**
     * Returns the meta object for class '{@link com.bl4ckcode.sces.models.Pedido <em>Pedido</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Pedido</em>'.
     * @see com.bl4ckcode.sces.models.Pedido
     * @generated
     */
    EClass getPedido();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Pedido#getCodigoPedido <em>Codigo Pedido</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Codigo Pedido</em>'.
     * @see com.bl4ckcode.sces.models.Pedido#getCodigoPedido()
     * @see #getPedido()
     * @generated
     */
    EAttribute getPedido_CodigoPedido();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Pedido#getDataPedido <em>Data Pedido</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Data Pedido</em>'.
     * @see com.bl4ckcode.sces.models.Pedido#getDataPedido()
     * @see #getPedido()
     * @generated
     */
    EAttribute getPedido_DataPedido();

    /**
     * Returns the meta object for the containment reference '{@link com.bl4ckcode.sces.models.Pedido#getClientes <em>Clientes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Clientes</em>'.
     * @see com.bl4ckcode.sces.models.Pedido#getClientes()
     * @see #getPedido()
     * @generated
     */
    EReference getPedido_Clientes();

    /**
     * Returns the meta object for the containment reference list '{@link com.bl4ckcode.sces.models.Pedido#getItens_do_pedido <em>Itens do pedido</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Itens do pedido</em>'.
     * @see com.bl4ckcode.sces.models.Pedido#getItens_do_pedido()
     * @see #getPedido()
     * @generated
     */
    EReference getPedido_Itens_do_pedido();

    /**
     * Returns the meta object for class '{@link com.bl4ckcode.sces.models.ItensPedido <em>Itens Pedido</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Itens Pedido</em>'.
     * @see com.bl4ckcode.sces.models.ItensPedido
     * @generated
     */
    EClass getItensPedido();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.ItensPedido#getQuantidade <em>Quantidade</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Quantidade</em>'.
     * @see com.bl4ckcode.sces.models.ItensPedido#getQuantidade()
     * @see #getItensPedido()
     * @generated
     */
    EAttribute getItensPedido_Quantidade();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.ItensPedido#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see com.bl4ckcode.sces.models.ItensPedido#getId()
     * @see #getItensPedido()
     * @generated
     */
    EAttribute getItensPedido_Id();

    /**
     * Returns the meta object for the containment reference '{@link com.bl4ckcode.sces.models.ItensPedido#getProduto <em>Produto</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Produto</em>'.
     * @see com.bl4ckcode.sces.models.ItensPedido#getProduto()
     * @see #getItensPedido()
     * @generated
     */
    EReference getItensPedido_Produto();

    /**
     * Returns the meta object for the container reference '{@link com.bl4ckcode.sces.models.ItensPedido#getPedido <em>Pedido</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Pedido</em>'.
     * @see com.bl4ckcode.sces.models.ItensPedido#getPedido()
     * @see #getItensPedido()
     * @generated
     */
    EReference getItensPedido_Pedido();

    /**
     * Returns the meta object for class '{@link com.bl4ckcode.sces.models.Produto <em>Produto</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Produto</em>'.
     * @see com.bl4ckcode.sces.models.Produto
     * @generated
     */
    EClass getProduto();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Produto#getCodigoProduto <em>Codigo Produto</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Codigo Produto</em>'.
     * @see com.bl4ckcode.sces.models.Produto#getCodigoProduto()
     * @see #getProduto()
     * @generated
     */
    EAttribute getProduto_CodigoProduto();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Produto#getNome <em>Nome</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Nome</em>'.
     * @see com.bl4ckcode.sces.models.Produto#getNome()
     * @see #getProduto()
     * @generated
     */
    EAttribute getProduto_Nome();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Produto#getPreco <em>Preco</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Preco</em>'.
     * @see com.bl4ckcode.sces.models.Produto#getPreco()
     * @see #getProduto()
     * @generated
     */
    EAttribute getProduto_Preco();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Produto#getQuantidadeEstoque <em>Quantidade Estoque</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Quantidade Estoque</em>'.
     * @see com.bl4ckcode.sces.models.Produto#getQuantidadeEstoque()
     * @see #getProduto()
     * @generated
     */
    EAttribute getProduto_QuantidadeEstoque();

    /**
     * Returns the meta object for the containment reference '{@link com.bl4ckcode.sces.models.Produto#getCetgorias <em>Cetgorias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Cetgorias</em>'.
     * @see com.bl4ckcode.sces.models.Produto#getCetgorias()
     * @see #getProduto()
     * @generated
     */
    EReference getProduto_Cetgorias();

    /**
     * Returns the meta object for class '{@link com.bl4ckcode.sces.models.Categoria <em>Categoria</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Categoria</em>'.
     * @see com.bl4ckcode.sces.models.Categoria
     * @generated
     */
    EClass getCategoria();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Categoria#getCodigo <em>Codigo</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Codigo</em>'.
     * @see com.bl4ckcode.sces.models.Categoria#getCodigo()
     * @see #getCategoria()
     * @generated
     */
    EAttribute getCategoria_Codigo();

    /**
     * Returns the meta object for the attribute '{@link com.bl4ckcode.sces.models.Categoria#getNome <em>Nome</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Nome</em>'.
     * @see com.bl4ckcode.sces.models.Categoria#getNome()
     * @see #getCategoria()
     * @generated
     */
    EAttribute getCategoria_Nome();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    EcommerceposFactory getEcommerceposFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.bl4ckcode.sces.models.impl.ClienteImpl <em>Cliente</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.bl4ckcode.sces.models.impl.ClienteImpl
         * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getCliente()
         * @generated
         */
        EClass CLIENTE = eINSTANCE.getCliente();

        /**
         * The meta object literal for the '<em><b>CPF</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__CPF = eINSTANCE.getCliente_CPF();

        /**
         * The meta object literal for the '<em><b>Nome</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__NOME = eINSTANCE.getCliente_Nome();

        /**
         * The meta object literal for the '<em><b>Endereco</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__ENDERECO = eINSTANCE.getCliente_Endereco();

        /**
         * The meta object literal for the '<em><b>Estado</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__ESTADO = eINSTANCE.getCliente_Estado();

        /**
         * The meta object literal for the '<em><b>Municipio</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__MUNICIPIO = eINSTANCE.getCliente_Municipio();

        /**
         * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__EMAIL = eINSTANCE.getCliente_Email();

        /**
         * The meta object literal for the '<em><b>Senha</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__SENHA = eINSTANCE.getCliente_Senha();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__ID = eINSTANCE.getCliente_Id();

        /**
         * The meta object literal for the '<em><b>Telefone</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CLIENTE__TELEFONE = eINSTANCE.getCliente_Telefone();

        /**
         * The meta object literal for the '{@link com.bl4ckcode.sces.models.impl.PedidoImpl <em>Pedido</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.bl4ckcode.sces.models.impl.PedidoImpl
         * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getPedido()
         * @generated
         */
        EClass PEDIDO = eINSTANCE.getPedido();

        /**
         * The meta object literal for the '<em><b>Codigo Pedido</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PEDIDO__CODIGO_PEDIDO = eINSTANCE.getPedido_CodigoPedido();

        /**
         * The meta object literal for the '<em><b>Data Pedido</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PEDIDO__DATA_PEDIDO = eINSTANCE.getPedido_DataPedido();

        /**
         * The meta object literal for the '<em><b>Clientes</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PEDIDO__CLIENTES = eINSTANCE.getPedido_Clientes();

        /**
         * The meta object literal for the '<em><b>Itens do pedido</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PEDIDO__ITENS_DO_PEDIDO = eINSTANCE.getPedido_Itens_do_pedido();

        /**
         * The meta object literal for the '{@link com.bl4ckcode.sces.models.impl.ItensPedidoImpl <em>Itens Pedido</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.bl4ckcode.sces.models.impl.ItensPedidoImpl
         * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getItensPedido()
         * @generated
         */
        EClass ITENS_PEDIDO = eINSTANCE.getItensPedido();

        /**
         * The meta object literal for the '<em><b>Quantidade</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITENS_PEDIDO__QUANTIDADE = eINSTANCE.getItensPedido_Quantidade();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITENS_PEDIDO__ID = eINSTANCE.getItensPedido_Id();

        /**
         * The meta object literal for the '<em><b>Produto</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITENS_PEDIDO__PRODUTO = eINSTANCE.getItensPedido_Produto();

        /**
         * The meta object literal for the '<em><b>Pedido</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITENS_PEDIDO__PEDIDO = eINSTANCE.getItensPedido_Pedido();

        /**
         * The meta object literal for the '{@link com.bl4ckcode.sces.models.impl.ProdutoImpl <em>Produto</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.bl4ckcode.sces.models.impl.ProdutoImpl
         * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getProduto()
         * @generated
         */
        EClass PRODUTO = eINSTANCE.getProduto();

        /**
         * The meta object literal for the '<em><b>Codigo Produto</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRODUTO__CODIGO_PRODUTO = eINSTANCE.getProduto_CodigoProduto();

        /**
         * The meta object literal for the '<em><b>Nome</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRODUTO__NOME = eINSTANCE.getProduto_Nome();

        /**
         * The meta object literal for the '<em><b>Preco</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRODUTO__PRECO = eINSTANCE.getProduto_Preco();

        /**
         * The meta object literal for the '<em><b>Quantidade Estoque</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRODUTO__QUANTIDADE_ESTOQUE = eINSTANCE.getProduto_QuantidadeEstoque();

        /**
         * The meta object literal for the '<em><b>Cetgorias</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PRODUTO__CETGORIAS = eINSTANCE.getProduto_Cetgorias();

        /**
         * The meta object literal for the '{@link com.bl4ckcode.sces.models.impl.CategoriaImpl <em>Categoria</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.bl4ckcode.sces.models.impl.CategoriaImpl
         * @see com.bl4ckcode.sces.models.impl.EcommerceposPackageImpl#getCategoria()
         * @generated
         */
        EClass CATEGORIA = eINSTANCE.getCategoria();

        /**
         * The meta object literal for the '<em><b>Codigo</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORIA__CODIGO = eINSTANCE.getCategoria_Codigo();

        /**
         * The meta object literal for the '<em><b>Nome</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CATEGORIA__NOME = eINSTANCE.getCategoria_Nome();

    }

} //EcommerceposPackage
