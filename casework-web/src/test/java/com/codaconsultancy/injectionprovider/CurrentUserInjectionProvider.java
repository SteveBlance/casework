package com.codaconsultancy.injectionprovider;

import com.codaconsultancy.User;
import com.codaconsultancy.annotation.CurrentUser;
import com.codaconsultancy.testdata.UserTestdataBuilder;
import de.akquinet.jbosscc.needle.injection.InjectionProvider;
import de.akquinet.jbosscc.needle.injection.InjectionTargetInformation;

public class CurrentUserInjectionProvider implements InjectionProvider<User> {

    private User currentUser = new UserTestdataBuilder()
            .withUsername("jfrancis").withFirstname("Jerry")
            .withSurname("Francis").build();

    @Override
    public User getInjectedObject(Class<?> injectionPointType) {
        return currentUser;
    }

    @Override
    public boolean verify(InjectionTargetInformation injectionTargetInformation) {
        return injectionTargetInformation.isAnnotationPresent(CurrentUser.class);
    }

    @Override
    public Object getKey(InjectionTargetInformation injectionTargetInformation) {
        return CurrentUser.class;
    }

}
