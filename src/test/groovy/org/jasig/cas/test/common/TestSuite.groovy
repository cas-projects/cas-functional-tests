package org.jasig.cas.test.common
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.jasig.cas.test.login.*
import org.jasig.cas.test.validation.*

@RunWith(Suite.class)
@Suite.SuiteClasses([
    BadLoginSpec.class,
    GatewaySpec.class,
    LoginSpec.class,
    LoginSpecWithService.class,
    RenewSpec.class,
    ValidateSpec.class,
    MultiLevelProxySpec.class,
	PGTInvalidationByLogoutSpec.class,
	UnsuccessfulValidateServiceSpec.class,
	UnsuccessfulValidationAtServiceValidateSpec.class,
	UnsuccessfulValidationAtValidateSpec.class,
	ValidateFailureSpec.class,
	ValidateServiceSpec.class,
	ValidateServiceWithPGTSpec.class
])

public class TestSuite {
}
