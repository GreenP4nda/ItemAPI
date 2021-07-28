package at.green_panda.utilities.itemapi;

/**
 * Created by Green_Panda
 * Class create at 18.07.2021 09:50
 */
class IncompatibleMetaException extends Throwable {
    public IncompatibleMetaException(Class required, Class given) {
        super("Method requires " + required.getName() + ". Found" + given.getName() + "!");
    }
}
