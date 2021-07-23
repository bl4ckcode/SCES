package com.bl4ckcode.sces.models.impl;

import com.bl4ckcode.sces.models.Cliente;
import com.bl4ckcode.sces.models.EcommerceposPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cliente</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getCPF <em>CPF</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getNome <em>Nome</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getEndereco <em>Endereco</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getEstado <em>Estado</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getMunicipio <em>Municipio</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link com.bl4ckcode.sces.models.impl.ClienteImpl#getSenha <em>Senha</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClienteImpl extends MinimalEObjectImpl.Container implements Cliente {
    /**
     * The default value of the '{@link #getCPF() <em>CPF</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCPF()
     */
    protected static final String CPF_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCPF() <em>CPF</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getCPF()
     */
    protected String cpf = CPF_EDEFAULT;

    /**
     * The default value of the '{@link #getNome() <em>Nome</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getNome()
     */
    protected static final String NOME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNome() <em>Nome</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getNome()
     */
    protected String nome = NOME_EDEFAULT;

    /**
     * The default value of the '{@link #getEndereco() <em>Endereco</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getEndereco()
     */
    protected static final String ENDERECO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEndereco() <em>Endereco</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getEndereco()
     */
    protected String endereco = ENDERECO_EDEFAULT;

    /**
     * The default value of the '{@link #getEstado() <em>Estado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getEstado()
     */
    protected static final String ESTADO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEstado() <em>Estado</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getEstado()
     */
    protected String estado = ESTADO_EDEFAULT;

    /**
     * The default value of the '{@link #getMunicipio() <em>Municipio</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getMunicipio()
     */
    protected static final String MUNICIPIO_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMunicipio() <em>Municipio</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getMunicipio()
     */
    protected String municipio = MUNICIPIO_EDEFAULT;

    /**
     * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getEmail()
     */
    protected static final String EMAIL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getEmail()
     */
    protected String email = EMAIL_EDEFAULT;

    /**
     * The default value of the '{@link #getSenha() <em>Senha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getSenha()
     */
    protected static final String SENHA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSenha() <em>Senha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     * @ordered
     * @see #getSenha()
     */
    protected String senha = SENHA_EDEFAULT;

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
     * The default value of the '{@link #getTelefone() <em>Telefone</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTelefone()
     * @generated
     * @ordered
     */
    protected static final String TELEFONE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTelefone() <em>Telefone</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTelefone()
     * @generated
     * @ordered
     */
    protected String telefone = TELEFONE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ClienteImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EcommerceposPackage.Literals.CLIENTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setCPF(String newCPF) {
        String oldCPF = cpf;
        cpf = newCPF;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__CPF, oldCPF, cpf));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getNome() {
        return nome;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setNome(String newNome) {
        String oldNome = nome;
        nome = newNome;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__NOME, oldNome, nome));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setEndereco(String newEndereco) {
        String oldEndereco = endereco;
        endereco = newEndereco;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__ENDERECO, oldEndereco, endereco));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getEstado() {
        return estado;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setEstado(String newEstado) {
        String oldEstado = estado;
        estado = newEstado;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__ESTADO, oldEstado, estado));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setMunicipio(String newMunicipio) {
        String oldMunicipio = municipio;
        municipio = newMunicipio;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__MUNICIPIO, oldMunicipio, municipio));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setEmail(String newEmail) {
        String oldEmail = email;
        email = newEmail;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__EMAIL, oldEmail, email));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public String getSenha() {
        return senha;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void setSenha(String newSenha) {
        String oldSenha = senha;
        senha = newSenha;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__SENHA, oldSenha, senha));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__ID, oldId, id));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTelefone(String newTelefone) {
        String oldTelefone = telefone;
        telefone = newTelefone;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcommerceposPackage.CLIENTE__TELEFONE, oldTelefone, telefone));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EcommerceposPackage.CLIENTE__CPF:
                return getCPF();
            case EcommerceposPackage.CLIENTE__NOME:
                return getNome();
            case EcommerceposPackage.CLIENTE__ENDERECO:
                return getEndereco();
            case EcommerceposPackage.CLIENTE__ESTADO:
                return getEstado();
            case EcommerceposPackage.CLIENTE__MUNICIPIO:
                return getMunicipio();
            case EcommerceposPackage.CLIENTE__EMAIL:
                return getEmail();
            case EcommerceposPackage.CLIENTE__SENHA:
                return getSenha();
            case EcommerceposPackage.CLIENTE__ID:
                return getId();
            case EcommerceposPackage.CLIENTE__TELEFONE:
                return getTelefone();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EcommerceposPackage.CLIENTE__CPF:
                setCPF((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__NOME:
                setNome((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__ENDERECO:
                setEndereco((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__ESTADO:
                setEstado((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__MUNICIPIO:
                setMunicipio((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__EMAIL:
                setEmail((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__SENHA:
                setSenha((String) newValue);
                return;
            case EcommerceposPackage.CLIENTE__ID:
                setId((Integer)newValue);
                return;
            case EcommerceposPackage.CLIENTE__TELEFONE:
                setTelefone((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case EcommerceposPackage.CLIENTE__CPF:
                setCPF(CPF_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__NOME:
                setNome(NOME_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__ENDERECO:
                setEndereco(ENDERECO_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__ESTADO:
                setEstado(ESTADO_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__MUNICIPIO:
                setMunicipio(MUNICIPIO_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__EMAIL:
                setEmail(EMAIL_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__SENHA:
                setSenha(SENHA_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__ID:
                setId(ID_EDEFAULT);
                return;
            case EcommerceposPackage.CLIENTE__TELEFONE:
                setTelefone(TELEFONE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EcommerceposPackage.CLIENTE__CPF:
                return CPF_EDEFAULT == null ? cpf != null : !CPF_EDEFAULT.equals(cpf);
            case EcommerceposPackage.CLIENTE__NOME:
                return NOME_EDEFAULT == null ? nome != null : !NOME_EDEFAULT.equals(nome);
            case EcommerceposPackage.CLIENTE__ENDERECO:
                return ENDERECO_EDEFAULT == null ? endereco != null : !ENDERECO_EDEFAULT.equals(endereco);
            case EcommerceposPackage.CLIENTE__ESTADO:
                return ESTADO_EDEFAULT == null ? estado != null : !ESTADO_EDEFAULT.equals(estado);
            case EcommerceposPackage.CLIENTE__MUNICIPIO:
                return MUNICIPIO_EDEFAULT == null ? municipio != null : !MUNICIPIO_EDEFAULT.equals(municipio);
            case EcommerceposPackage.CLIENTE__EMAIL:
                return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
            case EcommerceposPackage.CLIENTE__SENHA:
                return SENHA_EDEFAULT == null ? senha != null : !SENHA_EDEFAULT.equals(senha);
            case EcommerceposPackage.CLIENTE__ID:
                return id != ID_EDEFAULT;
            case EcommerceposPackage.CLIENTE__TELEFONE:
                return TELEFONE_EDEFAULT == null ? telefone != null : !TELEFONE_EDEFAULT.equals(telefone);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (CPF: ");
        result.append(cpf);
        result.append(", nome: ");
        result.append(nome);
        result.append(", endereco: ");
        result.append(endereco);
        result.append(", estado: ");
        result.append(estado);
        result.append(", municipio: ");
        result.append(municipio);
        result.append(", email: ");
        result.append(email);
        result.append(", senha: ");
        result.append(senha);
        result.append(", id: ");
        result.append(id);
        result.append(", telefone: ");
        result.append(telefone);
        result.append(')');
        return result.toString();
    }

} //ClienteImpl
