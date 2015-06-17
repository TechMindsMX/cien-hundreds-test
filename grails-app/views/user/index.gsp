<meta name="layout" content="main">
<g:form url="[resource:userInstance, action:'save']" >
	<g:textField name="firstName" maxlength="100" placeholder="firstName"/>
	<g:textField name="middleName" maxlength="100" placeholder="middleName"/>
	<g:textField name="lastName" maxlength="100" placeholder="lastName"/>
	<g:field type="email" name="email" maxlength="200" placeholder="email"/>
	<g:field type="email" name="confirmEmail" maxlength="200" placeholder="confirmEmail"/>
	<g:textField name="telephone" maxlength="10" placeholder="telephone"/>
	<g:textField name="password" placeholder="password"/>
	<g:textField name="confirmPassword" placeholder="confirmPassword"/>
  <g:textField name="username" placeholder="username"/>
  <g:submitButton name="create" placeholder="Salvar" value="Enviar"/>

</g:form>

